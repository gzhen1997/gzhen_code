package com.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther gz
 * @date 2022-04-17  23:06
 * @description fanoutExchange配置类  广播交换机
 */
@Configuration
public class FanoutExchangeConfig {

    public static final String QUEUE_NAME_1 = "fanoutQueue_1";

    public static final String QUEUE_NAME_2 = "fanoutQueue_2";

    public static final String EXCHANGE_NAME = "fanoutExchange";


    @Bean(name = "fanoutQueue_1")
    public Queue fanoutQueue_1() {
        return QueueBuilder
                .durable(QUEUE_NAME_1).build();
    }


    @Bean(name = "fanoutQueue_2")
    public Queue fanoutQueue_2() {
        return QueueBuilder
                .durable(QUEUE_NAME_2).build();
    }


    @Bean
    public FanoutExchange fanoutExchange() {
        return ExchangeBuilder
                .fanoutExchange(EXCHANGE_NAME)
                .build();
    }

    @Bean
    public Binding fanoutBinding_1() {
        return BindingBuilder
                .bind(fanoutQueue_1())
                .to(fanoutExchange());
    }

    @Bean
    public Binding fanoutBinding_2() {
        return BindingBuilder
                .bind(fanoutQueue_2())
                .to(fanoutExchange());
    }


}
