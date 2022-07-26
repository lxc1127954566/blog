package com.mszl.blog_api.dao.pojo;


import lombok.Data;

@Data
public class Article {

    public static final int Article_TOP = 1;

    public static final int Article_Common = 0;

    private Long id;

    private String title;

    private String summary;

    private int commentCounts;

    private int viewCounts;

    private Long authorId;

    private Long bodyId;

    private Long categoryId;

    private int weight;

    private Long createDate;
}
