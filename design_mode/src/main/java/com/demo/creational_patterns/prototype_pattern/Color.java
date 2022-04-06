package com.demo.creational_patterns.prototype_pattern;

public class Color implements Cloneable{

    @Override
    protected Color clone() throws CloneNotSupportedException {
        Color color = null;
        try {
            color = (Color) super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return color;
    }
}
