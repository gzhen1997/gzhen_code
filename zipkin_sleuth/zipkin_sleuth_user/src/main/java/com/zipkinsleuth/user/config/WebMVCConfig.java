package com.zipkinsleuth.user.config;

import com.zipkinsleuth.user.intercepter.ReqInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @auther gz
 * @date 2022-05-05  15:26
 * @description
 */
@Configuration
public class WebMVCConfig implements WebMvcConfigurer {
    @Autowired
    private ReqInterceptor reqInterceptor;





    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addWebRequestInterceptor(reqInterceptor);
    }
}
