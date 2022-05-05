package com.zipkinsleuth.order.api;

import com.zipkinsleuth.order.model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @auther gz
 * @date 2022-05-05  13:47
 * @description
 */
@FeignClient(value = "zipkin-sleuth-user")
public interface UserAPI {

    @PostMapping("user/pay")
    void pay(Order order);
}
