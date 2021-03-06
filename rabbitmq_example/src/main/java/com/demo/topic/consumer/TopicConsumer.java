package com.demo.topic.consumer;

import com.demo.config.TopicExchangeConfig;
import com.demo.dto.UserLoginDto;
import com.demo.service.SysLogService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @auther gz
 * @date 2022-04-19  10:10
 * @description
 */

@Component
@Slf4j
public class TopicConsumer {

    @Resource
    private ObjectMapper objectMapper;

    @Resource
    private SysLogService sysLogService;


    @RabbitListener(queues = TopicExchangeConfig.QUEUE_NAME_1, containerFactory = "singleListenerContainer")
    public void consumerMsg_1(@Payload Message message) throws UnsupportedEncodingException {
        byte[] body = message.getBody();
        String msg = new String(body, "utf-8");
        log.info("监听队列1消费的消息为：{}", msg);
    }


//    @RabbitListener(queues = TopicExchangeConfig.QUEUE_NAME_2, containerFactory = "singleListenerContainer")
//    public void consumerMsg_2(@Payload Message message) throws UnsupportedEncodingException {
//        byte[] body = message.getBody();
//        String msg = new String(body, "utf-8");
//        log.info("监听队列2消费的消息为：{}", msg);
//    }

    @RabbitListener(queues = TopicExchangeConfig.QUEUE_NAME_2, containerFactory = "singleListenerContainer")
    public void consumerMsg_2(@Payload Message message) throws UnsupportedEncodingException {
        byte[] body = message.getBody();
        try {
            UserLoginDto userLoginDto = objectMapper.readValue(body, UserLoginDto.class);
            sysLogService.recordLog(userLoginDto);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
