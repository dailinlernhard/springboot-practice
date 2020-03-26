package com.tuna.springboot.jwt.test;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class CreateJwtTest {
    public static void main(String[] args) {
        JwtBuilder builder = Jwts.builder().setId("1")
                .setSubject("tuna")
                .setIssuedAt(new Date())
              //设置字符串secret，如果过短的话会出现异常：
                // java.lang.IllegalArgumentException: secret key byte array cannot be null or empty.
                .claim("roles","admin") //自定义claims存储数据
                .claim("logo","logo.png")//自定义claims存储数据
                .signWith(SignatureAlgorithm.HS256, "tuna_dai@16.com");
        System.out.println(builder.compact());
    }
}