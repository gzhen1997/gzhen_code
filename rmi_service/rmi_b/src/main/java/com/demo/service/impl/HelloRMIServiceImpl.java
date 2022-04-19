package com.demo.service.impl;

import com.demo.service.HelloRMIService;

/**
 * @auther gz
 * @date 2022-04-18  9:55
 * @description
 */

public class HelloRMIServiceImpl implements HelloRMIService {
    @Override
    public int getAdd(int x, int y) {
        return x + y;
    }
}
