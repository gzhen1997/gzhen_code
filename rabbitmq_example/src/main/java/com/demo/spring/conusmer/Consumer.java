package com.demo.spring.conusmer;

import com.demo.model.LoginEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @auther gz
 * @date 2022-04-16  21:19
 * @description
 */
@Slf4j
@Component
//@EnableAsync  默认就是异步执行器
public class Consumer implements ApplicationListener<LoginEvent> {
    @Override
    public void onApplicationEvent(LoginEvent event) {
        log.info("spring时间驱动接收到消息为：{}", event);
    }
}
