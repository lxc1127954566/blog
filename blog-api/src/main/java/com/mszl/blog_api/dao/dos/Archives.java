package com.mszl.blog_api.dao.dos;

import lombok.Data;

@Data
public class Archives {

    private String year;

    private String month;

    private Long count;

    public Archives() {
    }
}
