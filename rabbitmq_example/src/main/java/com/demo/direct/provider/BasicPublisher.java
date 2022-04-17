package com.demo.direct.provider;

import com.demo.config.DirectExchangeConfig;
import com.demo.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.AbstractJavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * @auther gz
 * @date 2022-04-17  18:53
 * @description 生成者
 */
@Component
@Slf4j
public class BasicPublisher {


    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMsg(String message) {
        if (StringUtils.isNotBlank(message)) {
            try {
                rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
                rabbitTemplate.setExchange(DirectExchangeConfig.EXCHANGE_NAME);
                rabbitTemplate.setRoutingKey(DirectExchangeConfig.ROUTING_KEY);
                Message msg = MessageBuilder
                        .withBody(objectMapper.writeValueAsString(message.getBytes(StandardCharsets.UTF_8)).getBytes(StandardCharsets.UTF_8))
                        .build();
//              序列化方式和上面配置的序列化方式不一致，这个默认使用的是jdk的序列化方式，而上面指定的是Jackson的序列化方式
//                Message msg = MessageBuilder
//                        .withBody(message.getBytes(StandardCharsets.UTF_8))
//                        .build();
//                rabbitTemplate.convertAndSend(msg);
                rabbitTemplate.convertAndSend(msg);
            } catch (Exception e) {
                log.error("发送信息异常,cause({})", e.getMessage());
            }
        }
    }


    public void sendObjectMsg(Person person) {
        try {
            rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
            rabbitTemplate.setExchange(DirectExchangeConfig.EXCHANGE_NAME);
            rabbitTemplate.setRoutingKey(DirectExchangeConfig.ROUTING_KEY);
            Message msg = MessageBuilder.withBody(objectMapper.writeValueAsBytes(person)).build();
            rabbitTemplate.convertAndSend(msg, message -> {
                MessageProperties messageProperties = message.getMessageProperties();
                // 设置持久化方式
                messageProperties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                // 设置消息类型
                messageProperties.setHeader(AbstractJavaTypeMapper.DEFAULT_CLASSID_FIELD_NAME, Person.class);
                return message;
            });
        } catch (Exception e) {
            log.error("发送信息异常,cause({})", e.getMessage());
        }
    }


}
