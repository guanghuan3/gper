package com.guanghuan3.homework.multithread.lesson3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator
 * on 2019/5/21.
 */
public class TestReentrantLockLock {

    /**
     * 互斥重入锁
     */
    private Lock lock = new ReentrantLock();

    public void method1() {
        // 获得锁
        lock.lock();
        // 在所内调用method2
        method2();
        // 释放锁
        lock.unlock();
    }

    public void method2() {
        // 从method1中调用method2后不需要获取锁，只需要重入次数+1
        lock.lock();
        // 重入锁内执行method2
        System.err.println("method2");
        // 重入次数-1
        lock.unlock();
    }

    public static void main(String[] args) {
        new TestReentrantLockLock().method1();
    }
}
