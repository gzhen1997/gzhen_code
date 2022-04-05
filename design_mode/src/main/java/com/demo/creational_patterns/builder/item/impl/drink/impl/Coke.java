package com.demo.creational_patterns.builder.item.impl.drink.impl;

import com.demo.creational_patterns.builder.item.impl.drink.ColdDrink;

public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "可口可乐";
    }

    @Override
    public float price() {
        return 3.5f;
    }
}
