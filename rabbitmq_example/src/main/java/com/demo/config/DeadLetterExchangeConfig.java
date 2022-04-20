package com.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * @auther gz
 * @date 2022-04-20  16:46
 * @description 私信队列/延迟队列
 */
@Configuration
public class DeadLetterExchangeConfig {

    @Bean
    public DirectExchange deadLetterExchange() {
        return ExchangeBuilder
                .directExchange("deadLetterExchange")
                .build();
    }

    @Bean
    public Queue deadLetterQueue() {
        return QueueBuilder
                .durable("deadLetterQueue")
                .build();
    }

    @Bean
    public Binding deadLetterBinding() {
        return BindingBuilder
                .bind(deadLetterQueue())
                .to(deadLetterExchange())
                .with("dead.letter.key");
    }

    @Bean
    public Queue normalQueue() {
        HashMap<String, Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange", "deadLetterExchange");
        args.put("x-dead-letter-routing-key", "dead.letter.key");
        args.put("x-message-ttl", 10000);
        return QueueBuilder
                .durable("normalQueue")
                .withArguments(args)
                .build();
    }

    @Bean
    public DirectExchange normalDirectExchange() {
        return ExchangeBuilder
                .directExchange("normalDirectExchange")
                .build();
    }

    @Bean
    public Binding normalDirectBinding() {
        return BindingBuilder
                .bind(normalQueue())
                .to(normalDirectExchange())
                .with("normal.key");
    }
}
