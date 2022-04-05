package com.demo.creational_patterns.singleton_pattern;

/**
 * 饿汉式
 * 类加载时就初始化，浪费内存。
 * 它基于 classloader 机制避免了多线程的同步问题，不过，instance 在类装载时就实例化，
 * 虽然导致类装载的原因有很多种，在单例模式中大多数都是调用 getInstance 方法， 但是也
 * 不能确定有其他的方式（或者其他的静态方法）导致类装载，这时候初始化 instance 显然没
 * 有达到 lazy loading 的效果。
 */
public class Hungry {


    private static Hungry hungry = new Hungry();

    private Hungry() {
    }

    public static Hungry getHungry() {
        return hungry;
    }
}
