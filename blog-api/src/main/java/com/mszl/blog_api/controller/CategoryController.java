package com.mszl.blog_api.controller;


import com.mszl.blog_api.service.CategoryService;
import com.mszl.blog_api.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "文章类别控制台", tags = { "文章类别接口" })
@RestController
@RequestMapping("categorys")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 查询所有类别
     * */
    @ApiOperation(value = "查询所有类别接口")
    @GetMapping("getCategory")
    public Result findCategoryList(){
        return categoryService.findCategoryList();
    }


}
