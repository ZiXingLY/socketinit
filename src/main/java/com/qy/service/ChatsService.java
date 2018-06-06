package com.qy.service;
import com.qy.model.Chats;
import com.qy.base.core.Service;

import java.util.List;
import java.util.Map;


/**
 * Created by zaq on 2018/04/03.
 */
public interface ChatsService extends Service<Chats> {
    public List<Map> getUserChatsList(Integer send_id,Integer target_id);
    public List<Map> getUserChatsGroupList(Integer send_id);
    public List<Map> getUserGroup(Integer send_id,Integer target_id);
    public void batchChangeChatsReadState(Integer send_id,Integer target_id);

}
