package com.qy.dao;

import com.qy.base.core.Mapper;
import com.qy.model.Chats;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ChatsMapper extends Mapper<Chats> {
    public List<Map> getUserChatsList(@Param("send_id") Integer send_id, @Param("target_id") Integer target_id);
    public List<Map> getUserChatsGroupList(@Param("send_id") Integer member_id);
    public List<Map> getUserGroup(@Param("send_id") Integer send_id, @Param("target_id") Integer target_id);
    public void batchChangeChatsReadState(@Param("send_id") Integer send_id, @Param("target_id") Integer target_id);
}