package com.mszl.blog_api.controller;


import com.mszl.blog_api.aop.LogAnnotation;
import com.mszl.blog_api.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("upload")
@Api(value = "文件控制台", tags = {"博客文件接口"})
public class UploadController {

    @ApiOperation(value = "文件上传")
    @PostMapping
    @LogAnnotation(module = "文件", operation = "文件上传")
    public Result upload(@RequestParam("image") MultipartFile file) {
        //原始文件名称 aa.png
        String originalFilename = file.getOriginalFilename();
        //substringAfterLast("abcde","c") == "de"
        //唯一文件名称
        String fileName = UUID.randomUUID().toString() + "." + StringUtils.substringAfterLast(originalFilename, ".");
        return null;
    }
}
