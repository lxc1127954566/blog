package com.mszl.blog_api.controller;

import com.mszl.blog_api.service.TagService;
import com.mszl.blog_api.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("tags")
public class TagsController {

    @Autowired
    private TagService tagService;
    
    @GetMapping(value = "hot")
    public Result hot(){
        int limit = 6;
        return Result.success(tagService.hots(limit));

    }
}
