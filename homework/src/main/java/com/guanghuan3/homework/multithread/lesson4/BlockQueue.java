package com.guanghuan3.homework.multithread.lesson4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator
 * on 2019/5/28.
 */
public class BlockQueue {

    private int count;

    private int size;

    private Object[] queue;

    private Lock lock;

    private Condition takeCond;

    private Condition putCond;

    private boolean isInterrupt = false;

    public BlockQueue() {
        this.size = 10;
        init(size);
    }

    public BlockQueue(int size) {
        this.size = size;
        init(size);
    }

    private void init(int size) {
        count = 0;
        lock = new ReentrantLock();
        takeCond = lock.newCondition();
        putCond = lock.newCondition();
        queue = new Object[size];
    }

    public void put(Object obj) {
        lock.lock();

        try {
            if (count >= size) {
                try {
                    System.err.println("队列已经满了");
                    putCond.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }

            queue[count ++] = obj;
        } finally {
            takeCond.signal();
            lock.unlock();
        }
    }

    public Object take() {
        lock.lock();

        Object obj = null;
        try {
            if (count <= 0) {
                try {
                    System.err.println("队列已经空了");
                    takeCond.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            obj = queue[--count];
            // help GC
            queue[count] = null;
            return obj;
        } finally {
            putCond.signal();
            lock.unlock();
        }
    }

    public int getCount() {
        return this.count;
    }

}
