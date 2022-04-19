package com.demo.service.impl;

import com.demo.exception.CustException;
import com.demo.mapper.UserRowMapper;
import com.demo.model.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Types;
import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;




    @Override
    public void save(User user) throws CustException {


        jdbcTemplate.update("insert into user(name,age,sex) values (?,?,?);",
                new Object[]{user.getName(), user.getAge(), user.getSex()},
                new int[]{Types.VARCHAR, Types.INTEGER, Types.VARCHAR});
        // 普通异常不会回滚
        throw new CustException("自定义普通异常异常");

//        throw new RuntimeException("自定义运行异常");
//        ((UserServiceImpl) AopContext.currentProxy()).save2(user);

    }

    @Override
    public List<User> getUsers() {

        List<User> list = jdbcTemplate.query("select * from user ", new UserRowMapper());
        return list;
    }


    @Override
    public void save2(User user) {
        jdbcTemplate.update("insert into user(name,age,sex) values (?,?,?);",
                new Object[]{user.getName(), user.getAge(), user.getSex()},
                new int[]{Types.VARCHAR, Types.INTEGER, Types.VARCHAR});
    }
}
