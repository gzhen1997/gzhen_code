package com.demo.service.impl;

import com.demo.mapper.UserRowMapper;
import com.demo.model.User;
import com.demo.service.UserService;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void save(User user) {


        jdbcTemplate.update("insert into user(name,age,sex) values (?,?,?);",
                new Object[]{user.getName(), user.getAge(), user.getSex()},
                new int[]{Types.VARCHAR, Types.INTEGER, Types.VARCHAR});
        try {
            ((UserServiceImpl) AopContext.currentProxy()).save2(user);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }



    }

    @Override
    public List<User> getUsers() {
        List<User> list = jdbcTemplate.query("select * from user ", new UserRowMapper());
        return list;
    }

    @Transactional(propagation = Propagation.NESTED)
    @Override
    public void save2(User user) {
        jdbcTemplate.update("insert into user(name,age,sex) values (?,?,?);",
                new Object[]{user.getName() + 12, user.getAge(), user.getSex()},
                new int[]{Types.VARCHAR, Types.INTEGER, Types.VARCHAR});


        throw new RuntimeException("自定义异常00");
    }
}
