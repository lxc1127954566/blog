package com.mszl.blog_api.cache;

import java.lang.annotation.*;

//缓存接口
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Cache {

    long expire() default 1 * 60 *1000;
    //缓存标识
    String name() default "";
}
