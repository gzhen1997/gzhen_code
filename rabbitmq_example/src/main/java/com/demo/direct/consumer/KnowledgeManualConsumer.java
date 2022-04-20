package com.demo.direct.consumer;

import com.demo.model.KnowledgeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareBatchMessageListener;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @auther gz
 * @date 2022-04-19  17:21
 * @description
 */
//@Component("knowledgeManualConsumer")
@Slf4j
public class KnowledgeManualConsumer implements ChannelAwareMessageListener {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        MessageProperties messageProperties = message.getMessageProperties();
        // 获取消息分发时的全局唯一标识
        long deliveryTag = messageProperties.getDeliveryTag();
        try {
            byte[] body = message.getBody();
            KnowledgeInfo knowledgeInfo = objectMapper.readValue(body, KnowledgeInfo.class);
            log.info("手动确认消费模式，收到的消息为({})", knowledgeInfo);
            channel.basicAck(deliveryTag, true);
        } catch (Exception e) {
            log.info("手动确认模式失败，cause({})", e.getMessage());
            channel.basicReject(deliveryTag, false);
        }

    }
}
