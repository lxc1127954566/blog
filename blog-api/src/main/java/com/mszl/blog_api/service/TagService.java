package com.mszl.blog_api.service;


import com.mszl.blog_api.vo.Result;
import com.mszl.blog_api.vo.TagVo;

import java.util.List;

public interface TagService{

    List<TagVo> findTagsByArticleId(Long articleId);

    Result hots(int limit);

    Result findTagsList();
}
