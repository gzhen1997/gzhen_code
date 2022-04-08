package com.demo.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @auther gz
 * @date 2022-04-07  10:39
 * @description 实体类
 */
@ToString
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
