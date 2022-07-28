package com.mszl.blog_api.Utils;

import com.mszl.blog_api.dao.pojo.SysUser;

public class UserThreadLocal {

    private UserThreadLocal(){};

    private static final ThreadLocal<SysUser> LOCAL = new ThreadLocal<>();

    public static void put(SysUser sysUser){
        LOCAL.set(sysUser);
    }

    public static SysUser get(){
        return LOCAL.get();
    }

    public static void remove(){
        LOCAL.remove();
    }
}
