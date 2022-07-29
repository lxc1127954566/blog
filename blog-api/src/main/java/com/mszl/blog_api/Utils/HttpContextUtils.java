package com.mszl.blog_api.Utils;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/*
*   HttpServletRequest
* */
@Slf4j
public class HttpContextUtils {

    public static HttpServletRequest getHttpServletRequest(){
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /*
    * 获取IP地址
    * 使用Nginx等反向代理软件，则不能能通过request.getRemoteAddr()获取IP地址
    * 如果使用了多级反向代理的话，x-Forward-For的值并不止一个，而是一串的IP地址，x-forward-for中第一个#Unknown的有效IP字符串
    * */
    public static String getIp(HttpServletRequest request){
        String ip = null;
        String unknown = "unknown";
        String seperator = ",";
        int maxLength = 15;
        try{
            ip = request.getHeader("x-forward-for");
            if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)){
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (StringUtils.isEmpty(ip) || ip.length() == 0 || unknown.equalsIgnoreCase(ip)){
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)){
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)){
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)){
                ip = request.getRemoteAddr();
            }
        }catch (Exception e){
            log.error("getIp ERROR ",e);
        }

        if(StringUtils.isEmpty(ip) && ip.length() >maxLength){
            int idx = ip.indexOf(seperator);
            if (idx > 0 ){
                ip = ip.substring(0, idx);
            }
        }
        return ip;
    }
}
