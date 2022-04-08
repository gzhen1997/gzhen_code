package com.demo;

import com.demo.factory.FactoryUser;
import com.demo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class FactoryBeanTest {

    // 注意这里的类型不是FactoryUser
    @Resource
    private User factoryUser;

    @Resource(name = "&factoryUser")
    private FactoryUser factory;

    @Test
    public void test() throws Exception {
        System.out.println(factory.getObject());
        System.out.println(factoryUser);
    }
}
