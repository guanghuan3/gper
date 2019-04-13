package com.guanghuan3.homework.designpattern.singleton.register;

/**
 * Created by Administrator
 *
 * 线程隔离的注册式单例，内置线程安全机制，基于线程隔离
 * on 2019/4/13.
 */
public class ThreadLocalSingleton {

    private static ThreadLocal<ThreadLocalSingleton> threadLocal = new ThreadLocal<ThreadLocalSingleton>();

    public static void registerInstance(ThreadLocalSingleton instance) {
        threadLocal.set(instance);
    }

    public static ThreadLocalSingleton getInstance(){
        return threadLocal.get();
    }
}
