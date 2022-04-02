package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
//    exposeProxy=true 可以在方法内部调用再进行增强 proxyTargetClass=true必须使用cglib代理
@EnableAspectJAutoProxy(exposeProxy = true)
public class AopServerStarter {
    public static void main(String[] args) {
        SpringApplication.run(AopServerStarter.class, args);
    }
}
