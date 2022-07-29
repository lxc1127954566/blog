package com.mszl.blog_api.controller;

import com.mszl.blog_api.aop.LogAnnotation;
import com.mszl.blog_api.service.TagService;
import com.mszl.blog_api.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.io.ResolverUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "博客文章控制台", tags = {"博客文章接口"})
@RestController
@RequestMapping("tags")
public class TagsController {

    @Autowired
    private TagService tagService;

    @ApiOperation(value = "热门标签接口")
    @GetMapping(value = "getHot")
    @LogAnnotation(module = "标签", operation = "获取热门标签")
    public Result hot() {
        int limit = 6;
        return Result.success(tagService.hots(limit));
    }

    /**
     * 查询所有标签
     */
    @ApiOperation(value = "查询所有标签接口")
    @GetMapping("getTags")
    @LogAnnotation(module = "标签", operation = "获取标签列表")
    public Result findTagsList() {
        return tagService.findTagsList();
    }

    @ApiOperation(value = "查询所有标签详情接口")
    @GetMapping("getTagsDetail")
    @LogAnnotation(module = "标签", operation = "获取标签详情列表")
    public Result findTagsDetailList() {
        return tagService.findTagsDetailList();
    }

    @ApiOperation(value = "通过id查询标签详情接口")
    @GetMapping("getTagsDetail/{id}")
    @LogAnnotation(module = "标签", operation = "通过id获取标签详情")
    public Result findTagsDetailById(@PathVariable("id") Long id) {
        return tagService.findTagsDetailById(id);
    }
}
