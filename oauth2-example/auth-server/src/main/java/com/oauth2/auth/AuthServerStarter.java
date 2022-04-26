package com.oauth2.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @auther gz
 * @date 2022-04-26  16:48
 * @description
 */
@SpringBootApplication
public class AuthServerStarter {
    public static void main(String[] args){
        SpringApplication.run(AuthServerStarter.class, args);
    }
}
