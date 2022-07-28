package com.mszl.blog_api.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mszl.blog_api.dao.mapper.ArticleMapper;
import com.mszl.blog_api.dao.pojo.Article;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ThreadService {

    @Async("taskExecutor")
    public void updateArticleViewCount(ArticleMapper articleMapper, Article article){

        try{
        int viewCounts = article.getViewCounts();
        Article articleUpdate = new Article();
        articleUpdate.setViewCounts(Integer.valueOf(viewCounts+ 1 ));

        LambdaQueryWrapper<Article> updateWrapper = new LambdaQueryWrapper();
        updateWrapper.eq(Article::getId,article.getId());
        updateWrapper.eq(Article::getViewCounts,Integer.valueOf(viewCounts));
        articleMapper.update(articleUpdate,updateWrapper);
            Thread.sleep(5000);
            System.out.println("更新完成！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
