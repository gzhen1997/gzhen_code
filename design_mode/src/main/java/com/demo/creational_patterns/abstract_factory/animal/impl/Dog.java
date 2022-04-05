package com.demo.creational_patterns.abstract_factory.animal.impl;

import com.demo.creational_patterns.abstract_factory.animal.Animal;

public class Dog implements Animal {

    @Override
    public void hobby() {
        System.out.println("Dog like bone");
    }
}
