package com.ds;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @auther gz
 * @date 2022-05-10  15:12
 * @description
 */
@SpringBootApplication
@MapperScan("com.ds.mapper")
public class DSServerStarter {
    public static void main(String[] args) {
        SpringApplication.run(DSServerStarter.class, args);
    }
}
