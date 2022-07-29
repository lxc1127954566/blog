package com.mszl.blog_api.controller;


import com.mszl.blog_api.aop.LogAnnotation;
import com.mszl.blog_api.service.RegisterService;
import com.mszl.blog_api.vo.Result;
import com.mszl.blog_api.vo.params.LoginParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "注册控制台", tags = {"注册接口"})
@RestController
@RequestMapping(value = "register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @ApiOperation(value = "注册接口")
    @PostMapping
    @Transactional(value = "事务回滚")
    @LogAnnotation(module = "注册", operation = "用户注册")
    public Result register(@RequestBody LoginParams loginParams) {
        return registerService.register(loginParams);
    }
}
