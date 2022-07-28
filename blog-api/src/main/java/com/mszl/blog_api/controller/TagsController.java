package com.mszl.blog_api.controller;

import com.mszl.blog_api.service.TagService;
import com.mszl.blog_api.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "博客文章控制台", tags = { "博客文章接口" })
@RestController
@RequestMapping("tags")
public class TagsController {

    @Autowired
    private TagService tagService;

    @ApiOperation(value = "热门标签接口")
    @GetMapping(value = "hot")
    public Result hot(){
        int limit = 6;
        return Result.success(tagService.hots(limit));
    }

    /**
     * 查询所有标签
     * */
    @ApiOperation(value = "查询所有标签接口")
    @GetMapping("getTags")
    public Result findTagsList(){
        return tagService.findTagsList();
    }
}
