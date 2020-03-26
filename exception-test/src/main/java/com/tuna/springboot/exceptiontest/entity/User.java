package com.tuna.springboot.exceptiontest.entity;

import lombok.Data;

@Data
public class User {
    /** 编号*/
    private Long id;
    /** 姓名*/
    private String name;
    /** 年龄*/
    private Integer age;
}
