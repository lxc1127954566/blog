package com.mszl.blog_api.service.serviceImp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mszl.blog_api.dao.mapper.CategoryMapper;
import com.mszl.blog_api.dao.pojo.Category;
import com.mszl.blog_api.service.CategoryService;
import com.mszl.blog_api.vo.CategoryVo;
import com.mszl.blog_api.vo.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public CategoryVo findCategoryById(Long categoryId) {
        Category category = categoryMapper.selectById(categoryId);
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category,categoryVo);
        return categoryVo;
    }

    @Override
    public Result findCategoryList() {
        List<Category> categorys = categoryMapper.selectList(new LambdaQueryWrapper<>());
        return Result.success(copyList(categorys));
    }

    private List<CategoryVo> copyList(List<Category> categorys) {
        List<CategoryVo> categoryVos = new ArrayList<>();
        for (Category category : categorys){
            categoryVos.add(copy(category));
        }
        return categoryVos;
    }

    private CategoryVo copy(Category category){
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category,categoryVo);
        return categoryVo;
    }
}
