package com.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @auther gz
 * @date 2022-04-16  22:07
 * @description rabbitmq配置类
 */
@Slf4j
@Configuration
public class RabbitmqConfig {


    @Autowired
    private Environment environment;


    @Autowired
    private CachingConnectionFactory connectionFactory;

    @Autowired
    private SimpleRabbitListenerContainerFactoryConfigurer factoryConfigurer;


    /**
     * 单一消费者实例
     *
     * @return 单一mq的监听工厂
     */
    @Bean(name = "singleListenerContainer")
    public SimpleRabbitListenerContainerFactory singleListenerContainer() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        // 设置并发消费者实例的初始化数量
        factory.setConcurrentConsumers(1);
        // 设置并发消费者实例的最大数量
        factory.setMaxConcurrentConsumers(1);
        // 设置每个消费者拉取消息的个数
        factory.setPrefetchCount(1);
        return factory;
    }


    /**
     * 多个消费者的实例配置
     *
     * @return
     */
    @Bean(name = "multiListenerContainer")
    public SimpleRabbitListenerContainerFactory multiListenerContainer() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        // 设置容器工厂所用的实例   多个一个重试监听器
        factoryConfigurer.configure(factory, connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        factory.setAcknowledgeMode(AcknowledgeMode.NONE);
        factory.setConcurrentConsumers(10);
        factory.setMaxConcurrentConsumers(15);
        factory.setPrefetchCount(10);
        return factory;

    }


    // 自定义配置Rabbitmq发送消息的操作组件RabbitmqTemplate
    @Bean
    public RabbitTemplate rabbitTemplate() {
        // 设置消息发送后进行确认
        connectionFactory.setPublisherConfirmType(CachingConnectionFactory.ConfirmType.CORRELATED);
//        connectionFactory.setPublisherConfirms(true);
        // 发送消息后返回确认信息
        connectionFactory.setPublisherReturns(true);


        // 构建发送消息组件实例对象
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);

        // 发送消息后，如果发送成功，则输出“消息发送成功”的反馈消息
        // 只要交换机接受到消息ack就会是true ,但并不意味这消息到达了队列
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                log.info("消息发送成功：correlationData({}),ack({}),cause({})", correlationData, ack, cause);
            }
        });
        // 队列要是收到消息后
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                log.error("消息丢失：：exchange({}),route({}),replyCode({}),replyText({}),message({})", exchange, routingKey, replyCode, replyText, message);
            }
        });
        // 如果不配置Mandatory的话 returnCallback()回调方法不生效
        rabbitTemplate.setMandatory(true);

        return rabbitTemplate;

    }


}
