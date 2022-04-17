package com.demo;

import com.demo.exception.CustException;
import com.demo.model.User;
import com.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JdbcServerTest {


    @Autowired
    private UserService userServiceImpl;

    @Test
    public void testSave() throws CustException {
        User user = new User(null, "岳不群", 45, "nv");
        userServiceImpl.save(user);
    }

    @Test
    public void testQuery(){
        List<User> users = userServiceImpl.getUsers();
        System.out.println(users);
    }

    @Test
    public void testSave2(){
        User user = new User(null, "admin123", 425, "nv");
        userServiceImpl.save2(user);
    }




}
