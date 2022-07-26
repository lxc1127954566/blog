package com.mszl.blog_api.vo.params;

import lombok.Data;

@Data
public class PagerParams {

    private int page = 1;

    private int pageSize = 10;
}
