package com.mszl.blog_api.service;

import com.mszl.blog_api.vo.Result;
import com.mszl.blog_api.vo.params.LoginParams;

public interface RegisterService {


    Result register(LoginParams loginParams);
}
