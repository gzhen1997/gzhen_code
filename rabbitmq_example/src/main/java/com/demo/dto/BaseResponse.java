package com.demo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @auther gz
 * @date 2022-04-20  15:56
 * @description
 */
@Data
public class BaseResponse implements Serializable {

    private String msg;

    private String code;

    public static BaseResponse success(String msg){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode("200");
        baseResponse.setMsg(msg);
        return baseResponse;
    }

    public static BaseResponse fail(String msg){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode("500");
        baseResponse.setMsg(msg);
        return baseResponse;
    }

}
