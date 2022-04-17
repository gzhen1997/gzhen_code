package com.demo.fanout.provider;

import com.demo.config.FanoutExchangeConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @auther gz
 * @date 2022-04-17  23:18
 * @description 生产者
 */
@Component
@Slf4j
public class FanoutProvider {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMsg(String msg) {
        try {
            rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
            rabbitTemplate.setExchange(FanoutExchangeConfig.EXCHANGE_NAME);
            rabbitTemplate.convertAndSend(msg);
        } catch (AmqpException e) {
            log.warn("发送信息出现异常，cause({})", e.getMessage());
        }
    }
}
