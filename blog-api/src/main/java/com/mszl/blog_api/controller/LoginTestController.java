package com.mszl.blog_api.controller;


import com.mszl.blog_api.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class LoginTestController {

    @GetMapping
    public Result test(){
        return Result.success(null);
    }
}
