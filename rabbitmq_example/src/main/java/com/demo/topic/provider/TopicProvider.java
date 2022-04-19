package com.demo.topic.provider;

import com.demo.config.RabbitmqConfig;
import com.demo.config.TopicExchangeConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @auther gz
 * @date 2022-04-19  10:04
 * @description
 */
@Component
@Slf4j
public class TopicProvider {


    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMsg(String msg, String routingKey) throws JsonProcessingException {
        try {
            rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
            rabbitTemplate.setExchange(TopicExchangeConfig.EXCHANGE_NAME);
            rabbitTemplate.setRoutingKey(routingKey);
            log.info("routingKey：({})，发送的消息为：({})", msg, routingKey);
            rabbitTemplate.convertAndSend(msg);
        } catch (AmqpException e) {
            e.printStackTrace();
        }

    }

}
