package com.zipkinsleuth.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
*   @auther gz
*   @date   2022-05-05  13:40
*   @description
*/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.zipkinsleuth.order.api")
public class OrderServerStarter {
    public static void main(String[] args){
        SpringApplication.run(OrderServerStarter.class, args);
    }
}
