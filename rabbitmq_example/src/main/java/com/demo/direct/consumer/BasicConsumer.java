package com.demo.direct.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @auther gz
 * @date 2022-04-17  20:50
 * @description 消费者
 */
@Component

@Slf4j
public class BasicConsumer {

//    @Autowired
//    private ObjectMapper objectMapper;

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

}
