package com.demo.creational_patterns.builder.item.impl.burger.impl;

import com.demo.creational_patterns.builder.item.impl.burger.Burger;

/**
 * 鸡肉汉堡
 */
public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 20.0f;
    }
}
