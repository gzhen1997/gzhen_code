package com.demo.model;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

import java.io.Serializable;

/**
 * @auther gz
 * @date 2022-04-16  21:16
 * @description
 */
@Data
public class LoginEvent extends ApplicationEvent implements Serializable {


    private String userName;

    private String loginTime;

    private String ip;
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public LoginEvent(Object source) {
        super(source);
    }

    public LoginEvent(Object source, String userName, String loginTime, String ip) {
        super(source);
        this.userName = userName;
        this.loginTime = loginTime;
        this.ip = ip;
    }
}
