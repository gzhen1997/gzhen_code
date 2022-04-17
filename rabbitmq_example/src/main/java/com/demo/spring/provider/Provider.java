package com.demo.spring.provider;

import com.demo.model.LoginEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @auther gz
 * @date 2022-04-16  21:21
 * @description
 */
@Component
@Slf4j
public class Provider {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void sendMsg() {
        LoginEvent loginEvent = new LoginEvent(this, "debug", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "127.0.0.1");
        log.info("spring时间驱动模型发送消息：{}", loginEvent);
        applicationEventPublisher.publishEvent(loginEvent);


    }


}
