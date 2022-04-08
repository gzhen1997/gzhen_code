package com.demo;

import com.demo.factory.FactoryUser;
import com.demo.model.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @auther gz
 * @date 2022-04-07  13:47
 * @description
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MybatisServerTest {

//    @Resource
//    private DataSource dataSource;
//
//    @Resource
//    private SqlSessionFactory sqlSessionFactory;
//
//    @Test
//    public void test(){
//        System.out.println(sqlSessionFactory);
//        System.out.println(dataSource);
//    }

    @Resource
    private User user;

    @Resource
    private User user2;

    @Resource(name = "&factoryUser")
    private FactoryUser factoryUser;



    @Test
    public void test() throws Exception {
        System.out.println(user);
        System.out.println(user2);
        System.out.println(factoryUser.getObject());
        System.out.println(factoryUser.getObject());
    }




}
