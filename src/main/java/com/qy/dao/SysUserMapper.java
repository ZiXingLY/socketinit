package com.qy.dao;

import com.qy.base.core.Mapper;
import com.qy.model.SysUser;

import java.util.List;
import java.util.Map;

public interface SysUserMapper extends Mapper<SysUser> {

    List<SysUser> selectByMap(Map map);
}