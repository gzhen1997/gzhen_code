package com.demo.creational_patterns.builder.item.impl.drink;

import com.demo.creational_patterns.builder.item.Item;
import com.demo.creational_patterns.builder.pack.Packing;
import com.demo.creational_patterns.builder.pack.impl.Bottle;

/**
 * 冷饮抽象类
 */
public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

}
