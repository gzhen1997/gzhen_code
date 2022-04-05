package com.demo.creational_patterns.builder.item.impl.drink.impl;

import com.demo.creational_patterns.builder.item.impl.drink.ColdDrink;

public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "百世可乐";
    }

    @Override
    public float price() {
        return 3.0f;
    }
}
