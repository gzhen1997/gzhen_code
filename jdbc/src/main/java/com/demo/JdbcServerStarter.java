package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
public class JdbcServerStarter {
    public static void main(String[] args) {
        SpringApplication.run(JdbcServerStarter.class,args);
    }
}
