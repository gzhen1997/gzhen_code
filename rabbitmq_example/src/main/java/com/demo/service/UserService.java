package com.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.dto.UserLoginDto;
import com.demo.mapper.UserMapper;
import com.demo.model.User;
import com.demo.topic.provider.TopicProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @auther gz
 * @date 2022-04-20  15:42
 * @description
 */
@Service
@Slf4j
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private TopicProvider topicProvider;


    public Boolean login(UserLoginDto userLoginDto) {
        User user = getUserByUserNameAndPassword(userLoginDto.getUsername(), userLoginDto.getPassword());
        if (user == null) {
            return false;
        } else {
            userLoginDto.setUserId(user.getId());
            // 发送账号登录成功日志信息
            topicProvider.sendMsgObject(userLoginDto);
            return true;
        }
    }


    public User getUserByUserNameAndPassword(String username, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(User::getUsername, username)
                .eq(User::getPassword, password);
        User user = userMapper.selectOne(queryWrapper);
        return user;
    }


}
