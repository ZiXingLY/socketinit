package com.qy.service.impl;

import com.qy.dao.SysUserMapper;
import com.qy.model.SysUser;
import com.qy.service.SysUserService;
import com.qy.base.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Created by hang on 2018/06/03.
 */
@Service
@Transactional
public class SysUserServiceImpl extends AbstractService<SysUser> implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> selectByMap(Map map){

        return sysUserMapper.selectByMap(map);
    }

  }
