package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @auther gzhen
 * @description 启动类
 */
@SpringBootApplication
/**
 * exposeProxy = true 可以将方法内部调用进行增强
 */
@EnableAspectJAutoProxy(exposeProxy = true)
//@EnableTransactionManagement
public class JdbcServerStarter {
    public static void main(String[] args) {
        SpringApplication.run(JdbcServerStarter.class,args);
    }
}
