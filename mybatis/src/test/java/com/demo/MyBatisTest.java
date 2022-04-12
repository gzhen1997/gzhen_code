package com.demo;

import com.alibaba.druid.pool.DruidDataSource;
import com.demo.mapper.BBB;
import com.demo.mapper.UserMapper;
import com.demo.model.User;
import com.demo.utils.MybatisUtil;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Test;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.context.support.StandardServletEnvironment;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

/**
 * @auther gz
 * @date 2022-04-07  13:48
 * @description
 */

public class MyBatisTest {

    @Test
    public void test() {
        SqlSession sqlSession = null;
        try {
            DataSource dataSource = DataSourceBuilder.create()
                    .driverClassName("com.mysql.cj.jdbc.Driver")
                    .url("jdbc:mysql://localhost:3306/mybatis?serverTimezone=GMT%2B8")
                    .username("root")
                    .password("123456")
                    .type(DruidDataSource.class)
                    .build();
            JdbcTransactionFactory jdbcTransactionFactory = new JdbcTransactionFactory();
            Environment environment = new Environment.Builder("dev")
                    .transactionFactory(jdbcTransactionFactory)
                    .dataSource(dataSource)
                    .build();
//            Environment environment = new Environment("development", jdbcTransactionFactory, dataSource);
            Configuration configuration = new Configuration(environment);
            configuration.addMapper(UserMapper.class);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
            sqlSession = sqlSessionFactory.openSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUser();
            for (User user : userList) {
                System.out.println(user);
            }

//            User user = new User("张无忌", 23, "nan");
//            List<Object> list = sqlSession.selectList("com.demo.mapper.UserMapper.getUser");
//            int insert = sqlSession.insert("com.demo.mapper.UserMapper.insertUser", user);
//            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null)
                sqlSession.close();
        }
    }


    @Test
    public void testJdbc() throws ClassNotFoundException, SQLException {
        Class<?> clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mybatis?serverTimezone=GMT%2B8",
                "root",
                "123456");
        String sql = "select * from user where id = ?;";
        // 不会产生sql注入的问题
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, 1);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
        }
    }

    @Test
    public void testMybatisByConfigFile() {
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void testInsert() {
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User("岳不群", 45, "unknown");
        int i = mapper.insertUser(user);
        // 提交事务
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void testSpringMvc() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ConfigurableEnvironment configurableEnvironment = new StandardServletEnvironment();


        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
        List<User> userList = userMapper.getUser();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void springMybatisTest() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        BBB bbb = (BBB) applicationContext.getBean("bbb");
        String aaa = bbb.aaa;
        System.out.println(aaa);


//        UserMapper userMapper =(UserMapper) applicationContext.getBean("userMapper");
//        List<User> userList = userMapper.getUser();
//        for (User user : userList) {
//            System.out.println(user);
//        }
    }


}
