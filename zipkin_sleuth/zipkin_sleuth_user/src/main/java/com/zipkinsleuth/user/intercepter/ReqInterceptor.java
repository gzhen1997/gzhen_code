package com.zipkinsleuth.user.intercepter;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

import java.util.Iterator;

/**
 * @auther gz
 * @date 2022-05-05  15:21
 * @description
 */
@Component
public class ReqInterceptor implements WebRequestInterceptor {
    @Override
    public void preHandle(WebRequest request) throws Exception {
        System.out.println(request);
        Iterator<String> headerNames = request.getHeaderNames();
        while (headerNames.hasNext()){
            String next = headerNames.next();
            System.out.println(next);
        }
    }

    @Override
    public void postHandle(WebRequest request, ModelMap model) throws Exception {
        System.out.println(request);
        System.out.println(model);
    }

    @Override
    public void afterCompletion(WebRequest request, Exception ex) throws Exception {
        System.out.println(request);
    }
}
