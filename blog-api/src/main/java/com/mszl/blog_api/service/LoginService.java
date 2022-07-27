package com.mszl.blog_api.service;

import com.mszl.blog_api.dao.pojo.SysUser;
import com.mszl.blog_api.vo.Result;
import com.mszl.blog_api.vo.params.LoginParams;


public interface LoginService {

    Result login(LoginParams loginParams);

    SysUser checkToken(String token);

    Result logout(String token);
}
