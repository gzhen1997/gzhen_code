package com.demo.factory;

import com.demo.model.User;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class FactoryUser implements InitializingBean, FactoryBean<User> {

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
        if (user == null)
            this.user = new User("gz",25,"男");

    }
}
