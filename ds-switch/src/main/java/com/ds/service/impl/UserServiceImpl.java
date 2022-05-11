package com.ds.service.impl;

import com.ds.annotation.DataSource;
import com.ds.dto.UserDto;
import com.ds.mapper.UserMapper;
import com.ds.model.User;
import com.ds.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @auther gz
 * @date 2022-05-11  14:13
 * @description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @DataSource(value = "slave")
    @Transactional
    @Override
    public void insert(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userMapper.insert(user);
    }
}
