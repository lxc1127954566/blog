package com.mszl.blog_api.controller;


import com.mszl.blog_api.aop.LogAnnotation;
import com.mszl.blog_api.service.CommentsService;
import com.mszl.blog_api.vo.Result;
import com.mszl.blog_api.vo.params.CommentParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "用户评论控制台", tags = {"用户评论接口"})
@RestController
@RequestMapping("comments")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @ApiOperation(value = "通过文章id显示评论接口")
    @GetMapping("article/{id}")
    @LogAnnotation(module = "评论", operation = "通过文章id获取评论")
    public Result comments(@PathVariable("id") Long id) {
        return commentsService.commentsByArticleId(id);
    }

    @ApiOperation(value = "文章评论接口")
    @PostMapping("create/change")
    @LogAnnotation(module = "类别", operation = "评论文章")
    public Result comment(@RequestBody CommentParam commentParam) {
        return commentsService.comment(commentParam);
    }
}
