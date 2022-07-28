package com.mszl.blog_api.controller;


import com.mszl.blog_api.service.LoginService;
import com.mszl.blog_api.vo.Result;
import com.mszl.blog_api.vo.params.LoginParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "登录控制台", tags = { "登录接口" })
@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "登录接口")
    @PostMapping
    public Result login(@RequestBody LoginParams loginParams){
        return loginService.login(loginParams);

    }
}
