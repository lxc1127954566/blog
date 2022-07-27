package com.mszl.blog_api.vo.params;

import lombok.Data;

@Data
public class LoginParams {

    private String account;

    private String password;

    private String nickname;
}
