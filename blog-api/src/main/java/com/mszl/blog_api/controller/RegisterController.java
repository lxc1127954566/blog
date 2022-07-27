package com.mszl.blog_api.controller;


import com.mszl.blog_api.service.RegisterService;
import com.mszl.blog_api.vo.Result;
import com.mszl.blog_api.vo.params.LoginParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping
    @Transactional
    public Result register(@RequestBody LoginParams loginParams){
        return registerService.register(loginParams);
    }
}
