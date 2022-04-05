package com.demo.creational_patterns.builder.pack.impl;

import com.demo.creational_patterns.builder.pack.Packing;

public class Bottle implements Packing {

    @Override
    public String pack() {
        return "打包材料：纸杯";
    }
}
