package com.mszl.blog_api.service;

import com.mszl.blog_api.dao.pojo.SysUser;
import com.mszl.blog_api.vo.Result;

public interface SysUserService {

    SysUser findUserById(Long id);

    SysUser findUser(String account, String password);

    /**
     * 根据token获取当前用户信息
     * */
    Result findUserByToken(String header);

    /**
     * 根据账户查找用户
     * */
    SysUser findByAccount(String account);

    void save(SysUser sysUser);
}
