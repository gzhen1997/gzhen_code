package com.zipkinsleuth.order.controller;

import com.zipkinsleuth.order.api.OrderAPI;
import com.zipkinsleuth.order.api.UserAPI;
import com.zipkinsleuth.order.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther gz
 * @date 2022-05-05  13:41
 * @description
 */
@RestController
@Slf4j
public class OrderController implements OrderAPI {


    @Autowired
    private UserAPI userClient;

    @Override
    public void addOrder(Order order) {
        saveOrder(order);
        // 调用user服务完成支付
        userClient.pay(order);
    }


    private void saveOrder(Order order) {
        log.info("订单({})保存成功", order);
    }
}
