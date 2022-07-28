package com.mszl.blog_api.vo.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "com.mszl.blog_api.vo.params.PagerParams", description = "分页信息")
public class PagerParams {

    @ApiModelProperty(value = "页码")
    private int page = 1;

    @ApiModelProperty(value = "步长")
    private int pageSize = 10;
}
