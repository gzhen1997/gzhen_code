package com.ds.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @auther gz
 * @date 2022-05-11  14:26
 * @description
 */

public class UserDto implements Serializable {

    private long id;

    private String username;

    private String pwd;

    private Date createTime = new Date();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
