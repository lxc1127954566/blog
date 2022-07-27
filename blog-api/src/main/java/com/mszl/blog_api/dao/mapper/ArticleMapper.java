package com.mszl.blog_api.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mszl.blog_api.dao.dos.Archives;
import com.mszl.blog_api.dao.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {


    List<Archives> selectListArchives();
}
