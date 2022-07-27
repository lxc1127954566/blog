package com.mszl.blog_api.controller;

import com.mszl.blog_api.service.SysUserService;
import com.mszl.blog_api.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {


    @Autowired
    private SysUserService sysUserService;

    /**
     * 根据头文件认证后返回当前用户
     * 该接口用于前端头部栏
     * */
    @GetMapping ("currentUser")
    public Result currentUser(@RequestHeader("Authorization") String token){
        return sysUserService.findUserByToken(token);
    }
}
