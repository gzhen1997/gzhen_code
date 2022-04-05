package com.demo.creational_patterns.abstract_factory.producer;

import com.demo.creational_patterns.abstract_factory.factory.AbstractFactory;
import com.demo.creational_patterns.abstract_factory.factory.AnimalFactory;
import com.demo.creational_patterns.abstract_factory.factory.ColorFactory;

/**
 * 工厂生成器
 */
public class FactoryProducer {

    public static AbstractFactory getFactory(String type) {
        if (type == null)
            return null;
        if (type.equalsIgnoreCase("color"))
            return new ColorFactory();
        else if (type.equalsIgnoreCase("animal"))
            return new AnimalFactory();
        return null;
    }
}
