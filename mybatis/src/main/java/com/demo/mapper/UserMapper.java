package com.demo.mapper;

import com.demo.annotation.CustomizeScanner;
import com.demo.maker.ScannerMarkerInterface;
import com.demo.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @auther gz
 * @date 2022-04-07  10:46
 * @description user映射接口
 */
//@CustomizeScanner

@ConditionalOnProperty(prefix = "mapper",name = "enabled",havingValue = "true")
//@PropertySource(value = "classpath:db.properties")
public interface UserMapper extends ScannerMarkerInterface {
    int insertUser(User user);

    List<User> getUser();

    User getUserById(@Param("id") Integer id);
}


