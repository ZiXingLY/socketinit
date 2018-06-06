package com.qy.controller;
import com.qy.base.core.Constants;
import com.qy.base.core.Result;
import com.qy.base.core.ResultGenerator;
import com.qy.base.utils.SortMapList;
import com.qy.model.Chats;
import com.qy.model.Member;
import com.qy.service.ChatsService;
import com.qy.base.core.PageBean;
import com.github.pagehelper.PageHelper;
import com.qy.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
* Created by zaq on 2018/04/03.
*/
@RestController
@RequestMapping("/chats")
public class ChatsController {
    @Resource
    private ChatsService chatsService;
    @Autowired
    private MemberService memberService;

    //获取消息内容列表
    @GetMapping("/msgList")
    public Result list(Chats chats,PageBean<Map> page) {
        //检查参数
        if (chats.getSend_id() == null){
            return ResultGenerator.errResult(Constants.CODE_ERR_PARAM);
        }
        //查看用户是否存在
        if (!memberService.judgeById(chats.getSend_id()) || !memberService.judgeById(chats.getTarget_id())){
            return ResultGenerator.errResult(Constants.CODE_ERR_ACCOUNT_NO_EXIST);
        }
        //改变用户的正在聊天中的用户id
        Member member = memberService.findById(chats.getSend_id());
        member.setChating_id(chats.getTarget_id());
        memberService.update(member);
        chatsService.batchChangeChatsReadState(chats.getSend_id(),chats.getTarget_id());
        PageHelper.startPage(page.getPageNum(),page.getSize(),"add_time desc");
        List<Map> list = chatsService.getUserChatsList(chats.getSend_id(),chats.getTarget_id());
        //对list内的add_time再进行正序排列
        SortMapList.sortStringMethod(list,"add_time");
        if (!list.isEmpty()){
            Member sendMember = memberService.findById(chats.getSend_id());
            Member targetMember = memberService.findById(chats.getTarget_id());
            for (Map map:list) {
                map.put("send_user_name",sendMember.getNickname());
                map.put("send_user_avatar",sendMember.getAvatar());
                map.put("target_user_name",targetMember.getNickname());
                map.put("target_user_avatar",targetMember.getAvatar());
            }
        }
        page.setList(list);
        return ResultGenerator.successResult(page);
    }
    //清除用户正在聊天中的用户id
    @GetMapping("/clearChatingId")
    public Result clearChatingId(Member member) {
        //检查参数
        if (member.getId() == null){
            return ResultGenerator.errResult(Constants.CODE_ERR_PARAM);
        }
        //查看用户是否存在
        if (!memberService.judgeById(member.getId())){
            return ResultGenerator.errResult(Constants.CODE_ERR_ACCOUNT_NO_EXIST);
        }
        //改变用户的正在聊天中的用户id
        member = memberService.findById(member.getId());
        member.setChating_id(0);
        memberService.update(member);
        return ResultGenerator.successResult();
    }
    //获取消息内容列表
    @GetMapping("/chatsGroupList")
    public Result chatsGroupList(Chats chats,PageBean<Map> page) {
        //检查参数
        if (chats.getSend_id() == null){
            return ResultGenerator.errResult(Constants.CODE_ERR_PARAM);
        }
        //查看用户是否存在
        if (!memberService.judgeById(chats.getSend_id())){
            return ResultGenerator.errResult(Constants.CODE_ERR_ACCOUNT_NO_EXIST);
        }
        PageHelper.startPage(page.getPageNum(),page.getSize(),"add_time desc");
        List<Map> list = chatsService.getUserChatsGroupList(chats.getSend_id());
        page.setList(list);
        return ResultGenerator.successResult(page);
    }
}
