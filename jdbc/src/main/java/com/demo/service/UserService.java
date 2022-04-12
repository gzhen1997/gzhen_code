package com.demo.service;

import com.demo.exception.CustException;
import com.demo.model.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRED)
public interface UserService {

    void save(User user) throws CustException;

    void save2(User user);

    List<User> getUsers();
}
