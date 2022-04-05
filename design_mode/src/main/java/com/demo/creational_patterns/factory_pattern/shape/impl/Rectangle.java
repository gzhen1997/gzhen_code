package com.demo.creational_patterns.factory_pattern.shape.impl;

import com.demo.creational_patterns.factory_pattern.shape.Shape;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
