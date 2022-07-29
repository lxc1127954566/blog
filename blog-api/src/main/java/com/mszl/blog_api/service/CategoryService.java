package com.mszl.blog_api.service;


import com.mszl.blog_api.vo.CategoryVo;
import com.mszl.blog_api.vo.Result;

public interface CategoryService{

    CategoryVo findCategoryById(Long categoryId);

    Result findCategoryDetailById(Long categoryId);

    Result findCategoryList();

    Result findCategoryDetailList();


}
