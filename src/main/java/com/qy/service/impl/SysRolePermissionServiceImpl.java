package com.qy.service.impl;

import com.qy.dao.SysRolePermissionMapper;
import com.qy.model.SysRolePermission;
import com.qy.service.SysRolePermissionService;
import com.qy.base.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by hang on 2018/06/03.
 */
@Service
@Transactional
public class SysRolePermissionServiceImpl extends AbstractService<SysRolePermission> implements SysRolePermissionService {
    @Resource
    private SysRolePermissionMapper sysRolePermissionMapper;

}
