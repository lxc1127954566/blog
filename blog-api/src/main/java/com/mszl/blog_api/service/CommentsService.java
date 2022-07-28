package com.mszl.blog_api.service;


import com.mszl.blog_api.vo.Result;
import com.mszl.blog_api.vo.params.CommentParam;

public interface CommentsService {

    Result commentsByArticleId(Long id);

    Result comment(CommentParam commentParam);
}
