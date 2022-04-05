package com.demo.creational_patterns.abstract_factory.factory;

import com.demo.creational_patterns.abstract_factory.animal.Animal;
import com.demo.creational_patterns.abstract_factory.color.Color;

public abstract class AbstractFactory {

    public abstract Color getColor(String color);

    public abstract Animal getAnimal(String animal);
}
