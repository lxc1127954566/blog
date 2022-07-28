package com.mszl.blog_api.dao.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Article {

    public static final int Article_TOP = 1;

    public static final int Article_Common = 0;

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String title;

    private String summary;

    private Integer commentCounts;

    private Integer viewCounts;

    private Long authorId;

    private Long bodyId;

    private Long categoryId;

    private Integer weight;

    private Long createDate;
}
