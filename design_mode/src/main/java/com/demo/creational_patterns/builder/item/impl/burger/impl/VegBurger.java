package com.demo.creational_patterns.builder.item.impl.burger.impl;

import com.demo.creational_patterns.builder.item.impl.burger.Burger;

/**
 * 素食汉堡
 */
public class VegBurger extends Burger {
    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 10.5f;
    }
}
