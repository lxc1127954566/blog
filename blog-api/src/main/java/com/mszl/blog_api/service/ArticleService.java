package com.mszl.blog_api.service;

import com.mszl.blog_api.vo.Result;
import com.mszl.blog_api.vo.params.ArticleParam;
import com.mszl.blog_api.vo.params.PagerParams;

public interface ArticleService {

    Result listArticle(PagerParams pagerParams);

    Result hotArticles(int limit);

    Result newArticles(int limit);

    Result listArchives();

    Result findArticleById(Long articleId);

    Result issueArticle(ArticleParam articleParam);
}
