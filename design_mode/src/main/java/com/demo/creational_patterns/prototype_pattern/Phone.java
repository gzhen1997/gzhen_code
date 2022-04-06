package com.demo.creational_patterns.prototype_pattern;

public class Phone implements Cloneable {

    private Color color;

//    // 浅拷贝
//    @Override
//    protected Phone clone() throws CloneNotSupportedException {
//        Phone phone = null;
//        try {
//            phone = (Phone) super.clone();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return phone;
//    }


    @Override
    protected Phone clone() throws CloneNotSupportedException {
        Phone phone = null;
        try {
            phone = (Phone) super.clone();
            Color color = phone.getColor().clone();
            phone.setColor(color);
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return phone;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
