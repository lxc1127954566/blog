package com.mszl.blog_api.vo.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "com.mszl.blog_api.vo.params.LoginParams", description = "登录信息")
public class LoginParams {

    @ApiModelProperty(value = "账户")
    private String account;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "别名")
    private String nickname;
}
