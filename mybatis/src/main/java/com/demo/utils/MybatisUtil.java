package com.demo.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @auther gz
 * @date 2022-04-07  16:09
 * @description mybatis工具类
 */

public class MybatisUtil {

    private final static SqlSessionFactory SQL_SESSION_FACTORY;

    static {
        String resource = "mybatis-config.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resource);
        }catch (IOException e){
            e.printStackTrace();
        }
        SQL_SESSION_FACTORY = new SqlSessionFactoryBuilder().build(reader);
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return SQL_SESSION_FACTORY;
    }

}
