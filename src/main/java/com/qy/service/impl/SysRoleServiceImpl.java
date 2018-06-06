package com.qy.service.impl;

import com.qy.dao.SysRoleMapper;
import com.qy.model.SysRole;
import com.qy.service.SysRoleService;
import com.qy.base.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by hang on 2018/06/03.
 */
@Service
@Transactional
public class SysRoleServiceImpl extends AbstractService<SysRole> implements SysRoleService {
    @Resource
    private SysRoleMapper sysRoleMapper;

}
