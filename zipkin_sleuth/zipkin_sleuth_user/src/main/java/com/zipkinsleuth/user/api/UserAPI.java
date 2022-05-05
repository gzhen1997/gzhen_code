package com.zipkinsleuth.user.api;

import com.zipkinsleuth.user.model.Order;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @auther gz
 * @date 2022-05-05  13:47
 * @description
 */
public interface UserAPI {

    /**
     * 订单支付
     *
     * @param order 订单
     */
    @PostMapping("user/pay")
    void pay(Order order);
}
