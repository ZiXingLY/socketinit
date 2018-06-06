package com.qy.service.impl;

import com.qy.dao.ChatsGroupMemberMapper;
import com.qy.model.ChatsGroupMember;
import com.qy.service.ChatsGroupMemberService;
import com.qy.base.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by zaq on 2018/04/05.
 */
@Service
@Transactional
public class ChatsGroupMemberServiceImpl extends AbstractService<ChatsGroupMember> implements ChatsGroupMemberService {
    @Resource
    private ChatsGroupMemberMapper qyChatsGroupMemberMapper;

}
