package com.ds.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther gz
 * @date 2022-05-10  16:32
 * @description
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<CustResFilter> filterRegistration(CustResFilter custResFilter) {
        FilterRegistrationBean<CustResFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(custResFilter);
        registrationBean.addUrlPatterns("/common.txt");
        // 值越大 执行越靠后
        registrationBean.setOrder(2);
        return registrationBean;
    }
}
