package com.qy.service.impl;

import com.qy.dao.ChatsGroupMapper;
import com.qy.model.ChatsGroup;
import com.qy.service.ChatsGroupService;
import com.qy.base.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by zaq on 2018/04/05.
 */
@Service
@Transactional
public class ChatsGroupServiceImpl extends AbstractService<ChatsGroup> implements ChatsGroupService {
    @Resource
    private ChatsGroupMapper qyChatsGroupMapper;

}
