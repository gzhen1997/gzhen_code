package com.demo.service;

import com.demo.model.User;

import java.util.List;

public interface UserService {

    void save(User user);

    void save2(User user);

    List<User> getUsers();
}
