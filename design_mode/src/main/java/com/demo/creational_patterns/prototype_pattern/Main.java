package com.demo.creational_patterns.prototype_pattern;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Phone phone = new Phone();
        Color color = new Color();
        System.out.println("color原始值:" + color);
        phone.setColor(color);
        Phone clone = phone.clone();
        System.out.println("clone:" + clone);
        System.out.println("clone.color:" + clone.getColor());
    }
}
