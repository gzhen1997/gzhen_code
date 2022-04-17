package com.demo.fanout.consumer;

import com.demo.config.FanoutExchangeConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * @auther gz
 * @date 2022-04-17  23:22
 * @description
 */
@Component
@Slf4j
public class FanoutConsumer {

    @RabbitListener(queues = FanoutExchangeConfig.QUEUE_NAME_1, containerFactory = "singleListenerContainer")
    public void consumerQueue1(@Payload Message message) {
        try {
            byte[] body = message.getBody();
            String msg = new String(body, "utf-8");
            log.info("{}:{}", FanoutExchangeConfig.QUEUE_NAME_1, msg);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    @RabbitListener(queues = FanoutExchangeConfig.QUEUE_NAME_2, containerFactory = "singleListenerContainer")
    public void consumerQueue2(@Payload Message message) {
        try {
            byte[] body = message.getBody();
            String msg = new String(body, "utf-8");
            log.info("{}:{}", FanoutExchangeConfig.QUEUE_NAME_2, msg);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
