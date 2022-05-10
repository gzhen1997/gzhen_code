package com.ds.config;

import com.alibaba.druid.util.Utils;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @auther gz
 * @date 2022-05-10  16:22
 * @description
 */
@Component
public class CustResFilter extends HttpFilter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        super.doFilter(request, response, chain);
    }

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String content = Utils.readFromResource("/static/common.txt");
        String replace = content.replace("this.buildFooter();", "");
        response.getWriter().write(replace);
    }
}
