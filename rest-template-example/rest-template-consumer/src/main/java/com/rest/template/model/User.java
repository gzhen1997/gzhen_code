package com.rest.template.model;

import java.io.Serializable;

/**
 * @auther gz
 * @date 2022-04-27  13:56
 * @description
 */

public class User implements Serializable {
    private String name;

    private String pwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
