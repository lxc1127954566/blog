package com.mszl.blog_api.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mszl.blog_api.dao.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagMapper extends BaseMapper<Tag> {

    /**
     * 1、根据文章id查询标签列表
     * @param articleId
     * @return
     * */
    List<Tag> findTagsByArticleId(Long articleId);

    /**
     * 1、查找{limit}条最热标签
     * @param limit
     * @return
     * */
    List<Long> findHotsTagId(int limit);

    List<Tag> findTagsByTagIds(List<Long> tagIds);
}
