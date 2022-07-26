package com.mszl.blog_api.service;

import com.mszl.blog_api.dao.pojo.SysUser;

public interface SysUserService {

    SysUser findUserById(Long id);
}
