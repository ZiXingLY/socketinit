package com.qy.service;
import com.qy.model.SysUser;
import com.qy.base.core.Service;

import java.util.List;
import java.util.Map;


/**
 * Created by hang on 2018/06/03.
 */
public interface SysUserService extends Service<SysUser> {
    List<SysUser>  selectByMap(Map<String, Object> map);
}
