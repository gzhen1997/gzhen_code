package com.zipkinsleuth.order.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @auther gz
 * @date 2022-05-05  13:42
 * @description
 */
@Data
public class Order {

    private int orderId;

    private int userId;

    private String pname;

    private BigDecimal amount;

}
