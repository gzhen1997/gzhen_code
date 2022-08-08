package com.demo.webflux.controller;

import com.demo.webflux.dao.UserRepository;
import com.demo.webflux.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Optional;

/**
 * @auther gz
 * @date 2022-07-04  11:16
 * @description
 */
@RestController
public class UserController {
//    @GetMapping("/user")
//    public Mono<Principal> getCurrentUser(Mono<Principal> principal) {
//        return principal;
//    }

    @Autowired
    private UserRepository userRepository;

    @GetMapping("user/{id}")
    public User findById(@PathVariable("id") long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.get();
    }


    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("d://abc.txt");
        BufferedInputStream bis = new BufferedInputStream(fileInputStream);
    }

}
