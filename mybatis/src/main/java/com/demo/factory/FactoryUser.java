package com.demo.factory;

import com.demo.model.User;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @auther gz
 * @date 2022-04-08  9:14
 * @description
 */
@Component
public class FactoryUser implements FactoryBean<User>, InitializingBean {

    private User user;

    @Override
    public User getObject() throws Exception {
        return this.user;
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.user = new User("root",23,"nan");
    }
}
