package com.mszl.blog_api.vo.params;


import com.mszl.blog_api.vo.CategoryVo;
import com.mszl.blog_api.vo.TagVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "com.mszl.blog_api.vo.params.ArticleParam", description = "文章信息")
public class ArticleParam {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "文章内容")
    private ArticleBodyParam body;

    @ApiModelProperty(value = "类别")
    private CategoryVo categoryVo;

    @ApiModelProperty(value = "简介")
    private String summary;

    @ApiModelProperty(value = "标签")
    private List<TagVo> tags;

    @ApiModelProperty(value = "标题")
    private String title;
}
