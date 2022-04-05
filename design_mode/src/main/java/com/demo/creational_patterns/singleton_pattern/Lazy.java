package com.demo.creational_patterns.singleton_pattern;

/**
 * 懒汉式及其变形式
 * 这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
 * 这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作。
 */
public class Lazy {

    private static Lazy lazy;

    private Lazy() {

    }

    public static Lazy getInstance() {
        if (lazy == null) {
            lazy = new Lazy();
        }
        return lazy;

    }


}
