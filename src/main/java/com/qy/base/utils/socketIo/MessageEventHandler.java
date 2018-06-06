package com.qy.base.utils.socketIo;

import java.util.*;

import com.corundumstudio.socketio.transport.NamespaceClient;
import com.qy.base.utils.DateUtil;
import com.qy.model.*;
import com.qy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;


@Component
public class MessageEventHandler
{
    private final SocketIOServer server;

    private final MemberService memberService;
    private final ChatsService chatsService;
    private final BlacklistService blacklistService;
    private final ChatsGroupService chatsGroupService;
    private final ChatsGroupMemberService chatsGroupMemberService;

    @Autowired
    public MessageEventHandler(SocketIOServer server, MemberService memberService, ChatsService chatsService, BlacklistService blacklistService, ChatsGroupService chatsGroupService, ChatsGroupMemberService chatsGroupMemberService) {
        this.server = server;
        this.memberService = memberService;
        this.chatsService = chatsService;

        this.blacklistService = blacklistService;
        this.chatsGroupService = chatsGroupService;
        this.chatsGroupMemberService = chatsGroupMemberService;
    }
    //添加connect事件，当客户端发起连接时调用，本文中将clientid与sessionid存入数据库
    //方便后面发送消息时查找到对应的目标client,
    @OnConnect
    public void onConnect(SocketIOClient client) {
//        UUID uuid = new UUID(client.getSessionId().getMostSignificantBits(), client.getSessionId().getLeastSignificantBits());
        for (SocketIOClient sClient:server.getAllClients()) {
            if (!judgeClientState(sClient)){
                sClient.disconnect();
            }
        }
        //设置用的uuid
        setUserSocketUUID(client);
    }
    public boolean judgeClientState(SocketIOClient client){
        NamespaceClient namespaceClient= (NamespaceClient) client;
        return namespaceClient.getBaseClient().isConnected();
    }
    //添加@OnDisconnect事件，客户端断开连接时调用，刷新客户端信息
    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {
        //连接关闭的时候清楚该用户的聊天中用户id
        List<Member> memberList = memberService.selectByCSql("socket_uuid='" + client.getSessionId()+"'");
        Member member = memberList.get(0);
        member.setChating_id(0);
        memberService.update(member);
        clearUserSocketUUID(client);
    }

    //消息接收入口，当接收到消息后，查找发送目标客户端，并且向该客户端发送消息，且给自己发送消息
    @OnEvent(value = "message_new")
    public void onEvent(SocketIOClient client, AckRequest request, Chats chats)
    {
        // 群聊       server.getBroadcastOperations().sendEvent("message",data);
        // chatevent为 事件的名称， data为发送的内容
//        System.out.println(server.getClient(UUID.fromString("b6ec72cd-3ca4-4095-a72b-fa9f4bb6e28e")));
//        server.getClient(uuid).sendEvent("message",data);

//        Random random = new Random();
//        chats.setMsg(String.valueOf(random.nextInt()) + ":" + chats.getMsg());
        if (chats.getSend_id() != null && chats.getTarget_id() != null && chats.getMsg() != null){
            //获取发送人和接收人的群组id
            List<Map> chatsGroupList = chatsService.getUserGroup(chats.getSend_id(),chats.getTarget_id());
            if (chatsGroupList.isEmpty()){
                //如果两人不属于一个群组就创建新的群组
                ChatsGroup chatsGroup = new ChatsGroup();
                chatsGroup.setAdd_time(DateUtil.getNowTimestamp());
                chatsGroupService.save(chatsGroup);
                List<ChatsGroupMember> chatsGroupMemberList = new ArrayList<>();
                ChatsGroupMember chatsGroupMember = new ChatsGroupMember();
                chatsGroupMember.setAdd_time(DateUtil.getNowTimestamp());
                chatsGroupMember.setChats_group_id(chatsGroup.getId());
                chatsGroupMember.setMember_id(chats.getSend_id());
                chatsGroupMemberList.add(chatsGroupMember);
                ChatsGroupMember chatsGroupMember1 = new ChatsGroupMember();
                chatsGroupMember1.setAdd_time(DateUtil.getNowTimestamp());
                chatsGroupMember1.setChats_group_id(chatsGroup.getId());
                chatsGroupMember1.setMember_id(chats.getTarget_id());
                chatsGroupMemberList.add(chatsGroupMember1);
                chatsGroupMemberService.save(chatsGroupMemberList);
                chats.setChats_group_id(chatsGroup.getId());
            }else {
                chats.setChats_group_id((Integer) chatsGroupList.get(0).get("chats_group_id"));
            }
            chats.setAdd_time(DateUtil.getNowTimestamp());
            Member targetMember = memberService.findById(chats.getTarget_id());
            Member sendMember = memberService.findById(chats.getSend_id());
            if (sendMember != null && targetMember != null){
                chats.setSend_user_name(sendMember.getNickname());
                chats.setSend_user_avatar(sendMember.getAvatar());
                chats.setTarget_user_name(targetMember.getNickname());
                chats.setTarget_user_avatar(targetMember.getAvatar());
                List<Blacklist> blacklistList = blacklistService.selectByCSql("user_id = " + chats.getSend_id() + " AND be_pulled_black_id = " + chats.getTarget_id());//查询两个用户是否存在屏蔽
                if (blacklistList.isEmpty()){
                    //向在线的目标发送消息
                    if (targetMember.getSocket_uuid() != null && targetMember.getSocket_uuid().length() > 0){
                        SocketIOClient targetClient = server.getClient(UUID.fromString(targetMember.getSocket_uuid()));
                        if (targetClient != null){
                            if (targetMember.getChating_id() != null && targetMember.getChating_id() > 0 && targetMember.getChating_id().equals(chats.getSend_id())){
                                chats.setRead_state(1);
                            }
                            targetClient.sendEvent("message",chats);
                        }
                    }
                    chats.setState(0);
                }else {
                    //发送失败
                    chats.setState(-1);
                }
            }else {
                chats.setState(-2);
            }
            //返回客户端消息
            request.sendAckData(chats);
            chatsService.save(chats);//保存消息
        }

    }
    //把客户端的最新uuid存入数据库绑定 为了下一次单聊消息
    private void setUserSocketUUID(SocketIOClient client){
        if (client != null){
            String user_id = client.getHandshakeData().getSingleUrlParam("user_id");
            if (user_id != null && user_id.length() > 0){
                Member member = memberService.findById(Integer.valueOf(user_id));
                if (member != null){
                    member.setSocket_uuid(client.getSessionId().toString());
                    memberService.update(member);
                }
            }
        }
    }
    //清除用户的聊天uuid防止发错消息
    private void clearUserSocketUUID(SocketIOClient client){
        if (client != null){
            String user_id = client.getHandshakeData().getSingleUrlParam("user_id");
            if (user_id != null){
                Member member = memberService.findById(Integer.valueOf(user_id));
                if (member != null){
                    member.setSocket_uuid("");
                    memberService.update(member);
                }
            }
        }
    }
}
