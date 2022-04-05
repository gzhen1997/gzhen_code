package com.demo.creational_patterns.singleton_pattern;

/**
 * 这种方式具备很好的 lazy loading，能够在多线程中很好的工作，但是，效率很低，99% 情况下不需要同步。
 * 优点：第一次调用才初始化，避免内存浪费。
 * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
 */
public class LazyThread {

    private static LazyThread lazyThread;

    private LazyThread() {
    }

    public static synchronized LazyThread getLazyThread() {
        if (lazyThread == null) {
            lazyThread = new LazyThread();
        }
        return lazyThread;

    }


    // 双重校验锁
    public static LazyThread getInstanceByDoubleCheckLock() {
        if (lazyThread == null) {
            synchronized (LazyThread.class) {
                if (lazyThread == null) {
                    lazyThread = new LazyThread();
                }
            }
        }
        return lazyThread;
    }



    /**
     * 登记式/静态内部类
     *
     * 执行显示的调用getInstance（）方法时才主动加载
     */
    private static class LazyThreadHolder {
        static {
            System.out.println("静态内部类中的静态代码块");
        }
        private static final LazyThread INSTANCE = new LazyThread();
    }

    public static final LazyThread getInstance() {
        return LazyThreadHolder.INSTANCE;
    }


    public static void main(String[] args) {
//        LazyThread instance = LazyThread.getInstance();
        LazyThread instance = LazyThread.getInstanceByDoubleCheckLock();
        System.out.println(instance);
    }
}
