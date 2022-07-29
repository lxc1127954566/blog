package com.mszl.blog_api.controller;

import com.mszl.blog_api.aop.LogAnnotation;
import com.mszl.blog_api.service.SysUserService;
import com.mszl.blog_api.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "用户控制台", tags = {"用户接口"})
@RestController
@RequestMapping("users")
public class UserController {


    @Autowired
    private SysUserService sysUserService;

    /**
     * 根据头文件认证后返回当前用户
     * 该接口用于前端头部栏
     */
    @ApiOperation(value = "认证后返回当前用户接口")
    @GetMapping("currentUser")
    @LogAnnotation(module = "用户", operation = "获取当前用户信息")
    public Result currentUser(@RequestHeader("Authorization") String token) {
        return sysUserService.findUserByToken(token);
    }
}
