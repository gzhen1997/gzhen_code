package com.demo.creational_patterns.factory_pattern.factory;

import com.demo.creational_patterns.factory_pattern.shape.Shape;
import com.demo.creational_patterns.factory_pattern.shape.impl.Circle;
import com.demo.creational_patterns.factory_pattern.shape.impl.Rectangle;
import com.demo.creational_patterns.factory_pattern.shape.impl.Square;

public class ShapeFactory {

    public Shape getShape(String shape) {
        if (shape == null) {
            return null;
        }
        if (shape.equalsIgnoreCase("CIRCLE"))
            return new Circle();
        else if (shape.equalsIgnoreCase("SQUARE"))
            return new Square();
        else if (shape.equalsIgnoreCase("RECTANGLE"))
            return new Rectangle();
        return null;

    }
}
