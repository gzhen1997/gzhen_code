package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @auther gz
 * @date 2022-04-16  21:26
 * @description
 */
@SpringBootApplication
@MapperScan("com.demo.mapper")
public class RabbitmqServerStarter {
    public static void main(String[] args) {
        SpringApplication.run(RabbitmqServerStarter.class, args);
    }

}
