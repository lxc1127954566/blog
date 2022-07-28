package com.mszl.blog_api.dao.pojo;

import lombok.Data;


@Data
public class Comments {

    private Long id ;

    private String content;

    private Long createDate;

    private Long articleId;

    private Long authorId;

    private Long parentId;

    private Integer level;

    private Long toUid;

}
