package com.demo.controller;

import com.demo.dto.BaseResponse;
import com.demo.dto.UserLoginDto;
import com.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther gz
 * @date 2022-04-20  15:40
 * @description
 */

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.POST, value = "/user/login")
    public BaseResponse userLogin(@RequestBody @Validated UserLoginDto userLoginDto) {
        Boolean flag = userService.login(userLoginDto);
        if (Boolean.TRUE.equals(flag)) {
            return BaseResponse.success(userLoginDto.getUsername() + ",登录成功!");
        } else {
            return BaseResponse.fail(userLoginDto.getUsername() + ",登录失败!");
        }
    }
}
