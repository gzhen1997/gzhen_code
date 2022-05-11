package com.ds.dto;

import java.io.Serializable;

/**
 * @auther gz
 * @date 2022-05-11  14:27
 * @description
 */

public class Response<T> implements Serializable {

    private String msg;

    private String code = "200";

    private T data;

    public Response<T> msg(String msg) {
        this.msg = msg;
        return this;
    }

    public Response<T> code(String code) {
        this.code = code;
        return this;
    }

    public Response<T> data(T data) {
        this.data = data;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
