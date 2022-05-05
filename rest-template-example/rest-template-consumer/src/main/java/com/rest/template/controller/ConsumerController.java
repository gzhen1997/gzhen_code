package com.rest.template.controller;

import com.rest.template.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther gz
 * @date 2022-04-27  11:04
 * @description
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/1/{username}")
    public String consumer(@PathVariable(name = "username") String username) {
        String url = "http://localhost:9200/provider/{1}";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class, username);
        HttpHeaders headers = response.getHeaders();
        List<String> token = headers.get("token");
        System.out.println("token" + token);
        String body = response.getBody();
        System.out.println("provider返回值：" + body);
        return body;
    }

    @GetMapping("/consumer/2/{username}")
    public String consumer2(@PathVariable(name = "username") String username) {
        String url = "http://localhost:9200/provider/{name}/{pwd}";
        Map<String, String> map = new HashMap<>();
        map.put("name", username);
        map.put("pwd", "123456");
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class, map);
        HttpHeaders headers = response.getHeaders();
        List<String> token = headers.get("token");
        System.out.println("token" + token);
        String body = response.getBody();
        System.out.println("provider返回值：" + body);
        return body;
    }

    @GetMapping("/consumer/3")
    public String consumer3() {
        String url = "http://localhost:9200/provider/{1}/{2}";
        User user = new User();
        user.setName("admin");
        user.setPwd("123456");
        String result = restTemplate.getForObject(url, String.class, user.getName(), user.getPwd());
        System.out.println(result);
        return result;
    }

    @GetMapping("/consumer/4")
    public String consumer4() {
        String url = "http://localhost:9200/provider/post/{1}";
        User user = new User();
        user.setName("admin");
        user.setPwd("123456");
        String post = restTemplate.postForObject(url, user, String.class, "post");
        return post;

    }

    @GetMapping("/consumer/addheaders/")
    public String consumer5() {
        String url = "http://localhost:9200/provider/exchange/{1}";
        User user = new User();
        user.setName("admin");
        user.setPwd("123456");
        HttpHeaders header = new HttpHeaders();
        header.add("cookie", "I'm your father");
        HttpEntity<User> httpEntity = new HttpEntity<>(user, header);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class, "exchange");
        String body = response.getBody();
        return body;
    }

    @GetMapping("/consumer/addheaders2/")
    public String consumer6() {
        String url = "http://localhost:9200/provider/post2/{1}";
        User user = new User();
        user.setName("admin");
        user.setPwd("123456");
        restTemplate.setInterceptors(Collections.singletonList((request, body, execution) -> {
            HttpHeaders headers = request.getHeaders();
            headers.add("cookie", URLEncoder.encode("拦截器的方式设置cookie", "utf-8"));
            return execution.execute(request, body);
        }));
        ResponseEntity<String> response = restTemplate.postForEntity(url, user, String.class, "post");
        String body = response.getBody();
        return body;
    }
}