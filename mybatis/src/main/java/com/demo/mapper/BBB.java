package com.demo.mapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @auther gz
 * @date 2022-04-11  10:47
 * @description
 */
public class BBB{
    @Value("${mapper.enabled}")
    public String aaa;
}