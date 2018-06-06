package com.qy.service.impl;

import com.qy.dao.SysUserRoleMapper;
import com.qy.model.SysUserRole;
import com.qy.service.SysUserRoleService;
import com.qy.base.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by hang on 2018/06/03.
 */
@Service
@Transactional
public class SysUserRoleServiceImpl extends AbstractService<SysUserRole> implements SysUserRoleService {
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

}
