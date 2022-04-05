package com.demo.creational_patterns.abstract_factory.factory;

import com.demo.creational_patterns.abstract_factory.animal.Animal;
import com.demo.creational_patterns.abstract_factory.animal.impl.Cat;
import com.demo.creational_patterns.abstract_factory.animal.impl.Dog;
import com.demo.creational_patterns.abstract_factory.color.Color;

public class AnimalFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Animal getAnimal(String animal) {
        if (animal == null)
            return null;
        if (animal.equalsIgnoreCase("cat"))
            return new Cat();
        else if (animal.equalsIgnoreCase("dog"))
            return new Dog();
        return null;
    }
}
