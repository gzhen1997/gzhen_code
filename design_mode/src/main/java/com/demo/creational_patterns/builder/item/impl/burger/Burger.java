package com.demo.creational_patterns.builder.item.impl.burger;

import com.demo.creational_patterns.builder.item.Item;
import com.demo.creational_patterns.builder.pack.Packing;
import com.demo.creational_patterns.builder.pack.impl.Wrapper;

/**
 * 汉堡抽象类
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

}
