package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @auther gz
 * @date 2022-04-07  10:38
 * @description 启动类
 */
@SpringBootApplication
//@ImportResource("classpath:mybatis-config.xml")
public class MybatisServerStarter {
    public static void main(String[] args){
        SpringApplication.run(MybatisServerStarter.class, args);
    }
    
}
