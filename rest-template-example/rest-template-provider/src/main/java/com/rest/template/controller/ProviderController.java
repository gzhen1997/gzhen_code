package com.rest.template.controller;

import com.rest.template.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @auther gz
 * @date 2022-04-27  11:05
 * @description
 */
@RestController
public class ProviderController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/provider/{username}")
    private String provider(@PathVariable("name") String username,
                            HttpServletResponse response) {
        response.addHeader("token", username);
        System.out.println("provider-service: " + username);
        return username;
    }

    @GetMapping("/provider/{name}/{pwd}")
    private String provider(@PathVariable("name") String name,
                            @PathVariable("pwd") String pwd,
                            HttpServletResponse response) {
        response.addHeader("token", name + ":" + pwd);
        System.out.println("provider-service: " + name + ":" + pwd);
        return name;
    }

    @PostMapping("/provider/post/{type}")
    private String provider2(@RequestBody User user,
                             @PathVariable("type") String type,
                             HttpServletResponse response) {
        System.out.println("type: " + type);
        response.addHeader("token", user.getName());
        System.out.println("provider-service: " + user);
        return user.getName();
    }

    @PostMapping("/provider/exchange/{type}")
    private String provider3(@RequestBody User user,
                             @PathVariable("type") String type,
                             HttpServletRequest request,
                             HttpServletResponse response) {
        System.out.println("type: " + type);
        System.out.println("cookie:" + request.getHeader("cookie"));
        System.out.println("provider-service: " + user);
        return user.getName();
    }


    @PostMapping("/provider/post2/{type}")
    private String provider4(@RequestBody User user,
                             @PathVariable("type") String type,
                             HttpServletRequest request
                            ) throws UnsupportedEncodingException {
        System.out.println("type: " + type);
        System.out.println("cookie:" + URLDecoder.decode(request.getHeader("cookie"),"utf-8"));
        System.out.println("provider-service: " + user);
        return user.getName();
    }
}
