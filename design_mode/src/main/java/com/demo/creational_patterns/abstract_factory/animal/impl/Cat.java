package com.demo.creational_patterns.abstract_factory.animal.impl;

import com.demo.creational_patterns.abstract_factory.animal.Animal;

public class Cat implements Animal {
    @Override
    public void hobby() {
        System.out.println("Cat like sleeping!");
    }
}
