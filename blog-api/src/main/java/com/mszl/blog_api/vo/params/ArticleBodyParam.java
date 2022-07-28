package com.mszl.blog_api.vo.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "com.mszl.blog_api.vo.params.ArticleBodyParam", description = "发布文章内容")
public class ArticleBodyParam {


    @ApiModelProperty(value = "文章内容")
    private String content;

    @ApiModelProperty(value = "编码集")
    private String contentHtml;
}
