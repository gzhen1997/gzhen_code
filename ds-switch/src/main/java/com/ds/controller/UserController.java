package com.ds.controller;

import com.ds.dto.Response;
import com.ds.dto.UserDto;
import com.ds.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther gz
 * @date 2022-05-11  14:26
 * @description
 */
@RestController
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @PostMapping("user/add")
    public Response<String> add(@RequestBody UserDto userDto) {
        try {
            userService.insert(userDto);
            return new Response<String>().msg("插入成功");
        } catch (Exception e) {
            logger.warn("插入数据异常，cause({})", e.getMessage());
            return new Response<String>().msg("插入失败").data(e.getMessage());
        }
    }
}
