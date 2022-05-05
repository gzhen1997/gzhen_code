package com.zipkinsleuth.order.api;

import com.zipkinsleuth.order.model.Order;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @auther gz
 * @date 2022-05-05  13:42
 * @description
 */

public interface OrderAPI {

    /**
     * 添加订单
     * @param order 订单
     */
    @PostMapping("order/add")
    void addOrder(Order order);
}
