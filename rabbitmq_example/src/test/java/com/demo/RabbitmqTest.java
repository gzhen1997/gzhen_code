package com.demo;

import com.demo.fanout.provider.FanoutProvider;
import com.demo.model.Person;
import com.demo.direct.provider.BasicPublisher;
import com.demo.spring.provider.Provider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @auther gz
 * @date 2022-04-16  21:27
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqTest {

    @Autowired
    private Provider provider;

    @Autowired
    private BasicPublisher basicPublisher;

//    @Autowired
//    private ObjectMapper objectMapper;

    @Autowired
    private FanoutProvider fanoutProvider;

    @Test
    public void test2() {
        String msg = "这是一个字符串";
        basicPublisher.sendMsg(msg);
    }

    @Test
    public void test3() {
        Person msg = new Person(1, "root", 25);
        basicPublisher.sendObjectMsg(msg);
    }

    @Test
    public void test4() {
        fanoutProvider.sendMsg("我不是你爸爸");
    }


    @Test
    public void testEvent() {
        provider.sendMsg();
    }

}
