package com.demo.webflux.dao;

import com.demo.webflux.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @auther gz
 * @date 2022-07-04  15:32
 * @description
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
