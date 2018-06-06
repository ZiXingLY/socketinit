package com.qy.service.impl;

import com.qy.dao.SysPermissionInitMapper;
import com.qy.model.SysPermissionInit;
import com.qy.service.SysPermissionInitService;
import com.qy.base.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by hang on 2018/06/03.
 */
@Service
@Transactional
public class SysPermissionInitServiceImpl extends AbstractService<SysPermissionInit> implements SysPermissionInitService {
    @Resource
    private SysPermissionInitMapper sysPermissionInitMapper;

}
