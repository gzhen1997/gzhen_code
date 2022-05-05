package com.zipkinsleuth.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @auther gz
 * @date 2022-05-05  13:41
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class UserServerStarter {
    public static void main(String[] args) {
        SpringApplication.run(UserServerStarter.class, args);
    }
}
