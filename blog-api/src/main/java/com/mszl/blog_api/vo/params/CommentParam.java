package com.mszl.blog_api.vo.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "com.mszl.blog_api.vo.params.CommentParam", description = "评论信息")
public class CommentParam {

    @ApiModelProperty(value = "文章id")
    private Long articleId;

    @ApiModelProperty(value = "评论内容")
    private String content;

    @ApiModelProperty(value = "父评论")
    private Long parent;

    @ApiModelProperty(value = "评论用户")
    private Long toUserId;
}
