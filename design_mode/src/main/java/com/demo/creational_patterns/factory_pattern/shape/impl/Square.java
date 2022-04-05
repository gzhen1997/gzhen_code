package com.demo.creational_patterns.factory_pattern.shape.impl;

import com.demo.creational_patterns.factory_pattern.shape.Shape;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("inside Square::draw() method.");
    }
}
