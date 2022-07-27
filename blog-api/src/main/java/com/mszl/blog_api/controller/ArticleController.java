package com.mszl.blog_api.controller;

import com.mszl.blog_api.service.ArticleService;
import com.mszl.blog_api.vo.Result;
import com.mszl.blog_api.vo.params.PagerParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//json数据进行交互
@RestController
@RequestMapping("articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public Result listArticle(PagerParams pagerParams){
        return articleService.listArticle(pagerParams);
    }

    @PostMapping(value = "/hot")
    public Result hotArticle(){
        int limit = 5;
        return Result.success(articleService.hotArticles(limit));
    }

    @PostMapping(value = "/new")
    public Result newArticle(){
        int limit = 5;
        return Result.success(articleService.newArticles(limit));
    }

    @PostMapping(value = "/listArchives")
    public Result listArchives(){
        return Result.success(articleService.listArchives());
    }
}
