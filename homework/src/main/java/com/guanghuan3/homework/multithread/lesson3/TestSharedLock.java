package com.guanghuan3.homework.multithread.lesson3;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Administrator
 * on 2019/5/21.
 */
public class TestSharedLock {

    /**
     * 重入共享所，读读共享，读写/写写互斥
     */
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    private Map<String, Object> map = new HashMap<>();

    public static void main(String[] args) {
        TestSharedLock l = new TestSharedLock();
        l.write("key", "value");
        Long startTime = System.currentTimeMillis();

        // 创建3个线程同时读取，有出现阻塞等待的请情况
        new Thread(()->l.readSynchronized("key", startTime)).start();
        new Thread(()->l.readSynchronized("key", startTime)).start();
        new Thread(()->l.readSynchronized("key", startTime)).start();

        // 创建3个线程同时读取，几乎都是同一时间读取的数据，不会阻塞
//            new Thread(()->l.readShared("key", startTime)).start();
//            new Thread(()->l.readShared("key", startTime)).start();
//            new Thread(()->l.readShared("key", startTime)).start();
    }

    // 使用synchronized互斥锁
    public synchronized Object readSynchronized(String key, Long startTime) {
        try {
            Object obj = map.get(key);
            long endTime = System.currentTimeMillis();
            Thread.sleep(3000);
            System.err.println("耗时：" + (endTime - startTime));
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void write(String key, Object obj) {
        rwl.writeLock().lock();
        try {
            map.put(key, obj);
        } finally {
            rwl.writeLock().unlock();
        }
    }

    public Object readShared(String key, Long startTime) {
        try {
            rwl.readLock().lock();
            Object obj = map.get(key);
            long endTime = System.currentTimeMillis();
            Thread.sleep(3000l);
            System.err.println("总共耗时：" + (endTime - startTime));
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwl.readLock().unlock();
        }
        return null;
    }
}
