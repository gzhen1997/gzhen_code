package com.demo.creational_patterns.abstract_factory.factory;

import com.demo.creational_patterns.abstract_factory.color.impl.Black;
import com.demo.creational_patterns.abstract_factory.color.Color;
import com.demo.creational_patterns.abstract_factory.color.impl.Red;
import com.demo.creational_patterns.abstract_factory.color.impl.Yellow;
import com.demo.creational_patterns.abstract_factory.animal.Animal;

public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        if (color == null)
            return null;
        if (color.equalsIgnoreCase("Yellow"))
            return new Yellow();
        else if (color.equalsIgnoreCase("red"))
            return new Red();
        else if (color.equalsIgnoreCase("Black"))
            return new Black();
        return null;
    }

    @Override
    public Animal getAnimal(String animal) {
        return null;
    }
}
