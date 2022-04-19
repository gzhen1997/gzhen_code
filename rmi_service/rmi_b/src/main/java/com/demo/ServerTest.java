package com.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @auther gz
 * @date 2022-04-18  10:01
 * @description
 */

public class ServerTest {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("applicationContext.xml");
    }
}
