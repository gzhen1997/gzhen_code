package com.demo.direct.consumer;

import com.demo.config.DirectExchangeConfig;
import com.demo.model.KnowledgeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;


/**
 * @auther gz
 * @date 2022-04-17  20:50
 * @description 消费者
 */
@Component
@Slf4j
public class BasicConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * @Payload String msg
     */

//    @RabbitListener(queues = "basicQueue", containerFactory = "singleListenerContainer")
    public void consumeMsg(@Payload Message message) {
        try {
            byte[] body = message.getBody();
            String msg = new String(body, "utf-8");
            log.info("消费的消息为：({})", msg);
        } catch (Exception e) {
            log.error("消费消息出现异常,cause({})", e.getMessage());
        }
    }

    //    @RabbitListener(queues = DirectExchangeConfig.QUEUE_NAME, containerFactory = "singleListenerContainerAutoAck")
    public void consumeMsgByAutoAck(@Payload Message message) {
        try {
            byte[] body = message.getBody();
            KnowledgeInfo knowledgeInfo = objectMapper.readValue(body, KnowledgeInfo.class);
            log.info("消费的消息为：({})", knowledgeInfo);
        } catch (Exception e) {
            log.error("消费消息出现异常,cause({})", e.getMessage());
        }
    }

    @RabbitListener(queues = DirectExchangeConfig.QUEUE_NAME, containerFactory = "singleListenerContainerManual")
    public void consumeMsgByManual(@Payload Message message, Channel channel) throws IOException {
        long deliveryTag = 0;
        try {
            byte[] body = message.getBody();
            deliveryTag = message.getMessageProperties().getDeliveryTag();
            KnowledgeInfo knowledgeInfo = objectMapper.readValue(body, KnowledgeInfo.class);
            log.info("消费的消息为：({})", knowledgeInfo);
            channel.basicAck(deliveryTag, true);
        } catch (Exception e) {
            log.error("消费消息出现异常,cause({})", e.getMessage());
            channel.basicReject(deliveryTag, false);
        }

    }


//    @RabbitListener(queues = "normalQueue", containerFactory = "singleListenerContainer")
    public void consumeMsg2(@Payload Message message) throws IOException {
        try {
            byte[] body = message.getBody();
            KnowledgeInfo knowledgeInfo = objectMapper.readValue(body, KnowledgeInfo.class);
            log.info("常规队列：消费的消息为：({})", knowledgeInfo);
        } catch (Exception e) {
            log.error("常规队列：消费消息出现异常,cause({})", e.getMessage());
        }

    }


    @RabbitListener(queues = "deadLetterQueue", containerFactory = "singleListenerContainer")
    public void consumeMsg3(@Payload Message message) throws IOException {
        try {
            byte[] body = message.getBody();
            KnowledgeInfo knowledgeInfo = objectMapper.readValue(body, KnowledgeInfo.class);
            log.info("死信队列：消费的消息为：({})", knowledgeInfo);
        } catch (Exception e) {
            log.error("死信队列：消费消息出现异常,cause({})", e.getMessage());
        }

    }


}
