package com.demo.creational_patterns.builder.item;

import com.demo.creational_patterns.builder.pack.Packing;

public interface Item {
    String name();

    Packing packing();

    float price();
}
