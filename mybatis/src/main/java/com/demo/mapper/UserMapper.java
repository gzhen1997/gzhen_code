package com.demo.mapper;

import com.demo.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @auther gz
 * @date 2022-04-07  10:46
 * @description user映射接口
 */

public interface UserMapper {

    int insertUser(User user);

    List<User> getUser();

    User getUserById(@Param("id") Integer id);
}
