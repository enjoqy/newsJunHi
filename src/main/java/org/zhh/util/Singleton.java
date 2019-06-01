package org.zhh.util;

/**
 *
 * 单例模式是一种常用的软件设计模式，其定义是单例对象的类只能允许一个实例存在。
 *
 * @Author junhi
 * @Date 2019/5/30 8:56
 */

public class Singleton {

    private Singleton(){}

    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }

    /**
     * 静态内部类[推荐用]
     * 类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM帮助我们保证了线程的安全性，
     *     在类进行初始化时，别的线程是无法进入的
     * 优点：避免了线程不安全，延迟加载，效率高。
     * @return
     */
    public static  Singleton getInstance(){
        return SingletonInstance.INSTANCE;
    }
}
