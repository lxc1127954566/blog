package com.mszl.blog_api.controller;

import com.mszl.blog_api.aop.LogAnnotation;
import com.mszl.blog_api.service.ArticleService;
import com.mszl.blog_api.vo.Result;
import com.mszl.blog_api.vo.params.ArticleParam;
import com.mszl.blog_api.vo.params.PagerParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


//json数据进行交互
@Api(value = "博客文章控制台", tags = { "博客文章接口" })
@RestController
@RequestMapping("articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 首页 文章列表
     * @PagerParams
     * @Return
     * */
    @ApiOperation(value = "获取文章列表接口")
    @PostMapping
    @LogAnnotation(module="文章",operation="获取文章列表")
    public Result listArticle(PagerParams pagerParams){
        return articleService.listArticle(pagerParams);
    }

    @ApiOperation(value = "最热门文章接口")
    @PostMapping(value = "/hot")
    public Result hotArticle(){
        int limit = 5;
        return articleService.hotArticles(limit);
    }

    @ApiOperation(value = "最新文章接口")
    @PostMapping(value = "/new")
    public Result newArticle(){
        int limit = 5;
        return articleService.newArticles(limit);
    }

    @ApiOperation(value = "文章归档接口")
    @PostMapping(value = "/listArchives")
    public Result listArchives(){
        return articleService.listArchives();
    }

    @ApiOperation(value = "通过文章Id查询文章接口")
    @PostMapping(value = "view/{id}")
    public Result findArticleId(@PathVariable("id") Long articleId){
        return articleService.findArticleById(articleId);
    }

    /**
     * 发布文章
     * */
    @ApiOperation(value = "发布文章接口")
    @PostMapping("issueArticle")
    public Result issueArticle(@RequestBody ArticleParam articleParam){
        return articleService.issueArticle(articleParam);
    }

}
