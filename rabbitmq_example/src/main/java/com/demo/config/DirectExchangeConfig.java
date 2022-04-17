package com.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;

/**
 * @auther gz
 * @date 2022-04-17  23:03
 * @description DirectExchange配置类
 */
public class DirectExchangeConfig {


    public static final String QUEUE_NAME = "basicQueue";

    public static final String EXCHANGE_NAME = "basicExchange";

    public static final String ROUTING_KEY = "basic";


    @Bean
    public Queue basicQueue() {
        return QueueBuilder
                .durable(QUEUE_NAME)
                .build();
    }

    @Bean
    public DirectExchange basicExchange() {
        return ExchangeBuilder
                .directExchange(EXCHANGE_NAME)
                .durable(true)
                .build();
    }

    @Bean
    public Binding basicBinding() {
        return BindingBuilder
                .bind(basicQueue())
                .to(basicExchange())
                .with(ROUTING_KEY);
    }
}
