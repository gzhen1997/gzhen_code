package com.zipkinsleuth.user.controller;

import com.zipkinsleuth.user.api.UserAPI;
import com.zipkinsleuth.user.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther gz
 * @date 2022-05-05  13:51
 * @description
 */
@RestController
@Slf4j
public class UserController implements UserAPI {

    @Override
    public void pay(Order order) {
        payOrder(order);
    }


    private void payOrder(Order order) {
        log.info("用户支付({})订单成功", order);
    }
}
