package com.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther gz
 * @date 2022-04-19  9:48
 * @description 主题交换机
 */
@Configuration
public class TopicExchangeConfig {

    public static final String QUEUE_NAME_1 = "topicQueue_1";
    public static final String QUEUE_NAME_2 = "topicQueue_2";

    public static final String EXCHANGE_NAME = "topicExchange";

    public static final String ROUTING_KEY_1 = "*.topic";
    public static final String ROUTING_KEY_2 = "#.topic";


    @Bean
    public TopicExchange topicExchange() {
        return ExchangeBuilder
                .topicExchange(EXCHANGE_NAME)
                .build();
    }

    @Bean
    public Queue topicQueue_1() {
        return QueueBuilder
                .durable(QUEUE_NAME_1)
                .build();
    }

    @Bean
    public Queue topicQueue_2() {
        return QueueBuilder
                .durable(QUEUE_NAME_2)
                .build();
    }


    @Bean
    public Binding topicBinding_1() {
        return BindingBuilder
                .bind(topicQueue_1())
                .to(topicExchange())
                .with(ROUTING_KEY_1);
    }


    @Bean
    public Binding topicBinding_2() {
        return BindingBuilder
                .bind(topicQueue_2())
                .to(topicExchange())
                .with(ROUTING_KEY_2);
    }
}
