package com.demo.creational_patterns.abstract_factory;

import com.demo.creational_patterns.abstract_factory.animal.Animal;
import com.demo.creational_patterns.abstract_factory.color.Color;
import com.demo.creational_patterns.abstract_factory.factory.AbstractFactory;
import com.demo.creational_patterns.abstract_factory.producer.FactoryProducer;

public class Main {

    public static void main(String[] args) {
        // 获取颜色工厂
        AbstractFactory colorFactory = FactoryProducer.getFactory("color");
        Color red = colorFactory.getColor("red");
        red.fill();
        // 获取动物工厂
        AbstractFactory animalFactory = FactoryProducer.getFactory("animal");
        Animal dog = animalFactory.getAnimal("dog");
        dog.hobby();


    }
}
