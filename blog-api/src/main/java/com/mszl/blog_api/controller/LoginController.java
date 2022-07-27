package com.mszl.blog_api.controller;


import com.mszl.blog_api.service.LoginService;
import com.mszl.blog_api.vo.Result;
import com.mszl.blog_api.vo.params.LoginParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public Result login(@RequestBody LoginParams loginParams){
        return loginService.login(loginParams);

    }
}
