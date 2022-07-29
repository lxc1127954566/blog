package com.mszl.blog_api.controller;


import com.mszl.blog_api.aop.LogAnnotation;
import com.mszl.blog_api.service.LoginService;
import com.mszl.blog_api.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "登出控制台", tags = {"登出接口"})
@RestController
@RequestMapping(value = "logout")
public class LogoutController {

    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "登出接口")
    @GetMapping
    @LogAnnotation(module = "登出", operation = "用户登出")
    public Result logout(@RequestHeader("Authorization") String token) {
        return loginService.logout(token);
    }
}
