package com.mszl.blog_api.controller;


import com.mszl.blog_api.aop.LogAnnotation;
import com.mszl.blog_api.service.CategoryService;
import com.mszl.blog_api.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "文章类别控制台", tags = {"文章类别接口"})
@RestController
@RequestMapping("categorys")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @ApiOperation(value = "查询所有类别接口")
    @GetMapping("getCategory")
    @LogAnnotation(module = "类别", operation = "获取类别列表")
    public Result findCategoryList() {
        return categoryService.findCategoryList();
    }


    @ApiOperation(value = "查询所有类别详情接口")
    @GetMapping("detail")
    @LogAnnotation(module = "类别", operation = "获取类别详情列表")
    public Result findCategoryDetailList() {
        return categoryService.findCategoryDetailList();
    }


    @ApiOperation(value = "通过id查询类别接口")
    @GetMapping("getCategoryById/{id}")
    @LogAnnotation(module = "类别", operation = "通过id获取类别")
    public Result findCategoryById(@PathVariable("id") Long categoryId) {
        return categoryService.findCategoryDetailById(categoryId);
    }

}
