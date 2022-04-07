package com.demo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable, Cloneable {

    private Integer id;

    private String username;

    private String password;

    @Override
    public User clone() throws CloneNotSupportedException {
        User user = null;
        try {
            user = (User) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
