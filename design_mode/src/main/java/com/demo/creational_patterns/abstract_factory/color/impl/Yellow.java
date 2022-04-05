package com.demo.creational_patterns.abstract_factory.color.impl;

import com.demo.creational_patterns.abstract_factory.color.Color;

public class Yellow implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Yellow:fill() method.");
    }
}
