package com.qy.service.impl;

import com.qy.dao.ChatsMapper;
import com.qy.model.Chats;
import com.qy.service.ChatsService;
import com.qy.base.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Created by zaq on 2018/04/03.
 */
@Service
@Transactional
public class ChatsServiceImpl extends AbstractService<Chats> implements ChatsService {
    @Resource
    private ChatsMapper qyChatsMapper;

    @Override
    public List<Map> getUserChatsList(Integer send_id,Integer target_id) {
        return qyChatsMapper.getUserChatsList(send_id,target_id);
    }

    @Override
    public List<Map> getUserChatsGroupList(Integer send_id) {
        return qyChatsMapper.getUserChatsGroupList(send_id);
    }

    @Override
    public List<Map> getUserGroup(Integer send_id, Integer target_id) {
        return qyChatsMapper.getUserGroup(send_id,target_id);
    }

    @Override
    public void batchChangeChatsReadState(Integer send_id, Integer target_id) {
        qyChatsMapper.batchChangeChatsReadState(send_id,target_id);
    }
}
