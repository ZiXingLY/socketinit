package com.qy.service.impl;

import com.qy.dao.BlacklistMapper;
import com.qy.model.Blacklist;
import com.qy.service.BlacklistService;
import com.qy.base.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by zaq on 2018/05/17.
 */
@Service
@Transactional
public class BlacklistServiceImpl extends AbstractService<Blacklist> implements BlacklistService {
    @Resource
    private BlacklistMapper qyBlacklistMapper;

}
