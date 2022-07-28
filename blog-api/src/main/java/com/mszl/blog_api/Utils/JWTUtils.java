package com.mszl.blog_api.Utils;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 1、JWT工具类，提供限时加密，解密方法
 * */
public class JWTUtils {

    private static final String jwtToken = "1127954566@!$$";

    public static String createToken(long userId){
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId",userId);
        JwtBuilder jwtBuilder = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,jwtToken)
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+ 24*60*60*1000));
        String token = jwtBuilder.compact();
        return token;
    }

    //解析token
    public static Map<String, Object> checkToken(String token){
        try {
            Jwt parse = Jwts.parser().setSigningKey(jwtToken).parse(token);
            return (Map<String, Object>) parse.getBody();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
