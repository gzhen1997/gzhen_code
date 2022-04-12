package com.demo.test;

import com.demo.exception.CustException;
import com.demo.model.User;
import com.demo.service.UserService;
import com.demo.service.impl.UserServiceImpl2;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @auther gz
 * @date 2022-04-11  15:14
 * @description
 */

public class SpringTest {


    @Test
    public void testSave() throws CustException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userServiceImpl2 =(UserService) context.getBean("userServiceImpl2");
        User user = new User(null, "张无忌", 23, "nan");
        userServiceImpl2.save(user);

    }
}
