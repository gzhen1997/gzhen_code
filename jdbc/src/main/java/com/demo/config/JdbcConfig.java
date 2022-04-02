package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        /**
           将statement对象生成所有的ResultSet对象设置最大行数的限制，
           如果查询的结果有100行但是设置最大的行数为10，那么只返回10行的数据
         */
        jdbcTemplate.setMaxRows(2);
        /**
         * 最主要为了减少网络交互次数设计的，当调用rs.next时ResultSet会一次性从服务器
         * 上获取指定行数（fetchSize）的数据回来，下次rs.next时从缓存中直接获取，减少
         * 网络开销。
         */
        jdbcTemplate.setFetchSize(10);
        return jdbcTemplate;
    }
}
