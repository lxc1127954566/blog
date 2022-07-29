package com.mszl.blog_api.vo.params;

import com.sun.istack.internal.NotNull;
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

    @ApiModelProperty(value = "类别")
    private Long categoryId;

    @ApiModelProperty(value = "标签")
    private Long tagId;

    @ApiModelProperty(value = "年")
    private String year;

    @ApiModelProperty(value = "月")
    private String month;

    //修改month格式，为符合MySQl数据
    public String getMonth(){
        if (this.month != null && this.month != ""){
            return "0" + this.month;
        }
        return this.month;
    }
}
