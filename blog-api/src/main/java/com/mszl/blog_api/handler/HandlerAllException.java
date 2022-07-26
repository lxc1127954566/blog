package com.mszl.blog_api.handler;

import com.mszl.blog_api.vo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//对加了@Controller注解的方法进行拦截处理 AOP实现
@ControllerAdvice
public class HandlerAllException{

    //进行异常处理，处理Exception.class异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result DoException(Exception ex){
        ex.printStackTrace();
        return Result.fail(600,"系统错误！");
    }
}
