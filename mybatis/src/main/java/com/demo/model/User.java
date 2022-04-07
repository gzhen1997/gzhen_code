package com.demo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @auther gz
 * @date 2022-04-07  10:39
 * @description 实体类
 */
@Data
public class User implements Serializable {

    private Integer id;

    private String name;

    private Integer age;

    private String sex;

    public User(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public User() {
    }
}
