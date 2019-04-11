package com.guanghuan3.homework.designpattern.singleton.lazy;

import java.io.Serializable;

/**
 * Created by Administrator
 * 当实现了Serialize接口时，重写readResolve方法防止返回的对象不是原来的单例。
 * 但是在反序列化时已经重新创建了一份新的实例，只是返回的时候通过readResolve方法指定返回了已经创建的实例
 * on 2019/4/11.
 */
public class LazySingleton1 implements Serializable{

    private static LazySingleton1 instance;

    // 避免遭受反射创建对象时强制创建实例
    private LazySingleton1(){
        if (instance != null) {
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    public static LazySingleton1 getInstance() {
        // 双check，优化synchronize
        if (instance  == null) {
            // 保证线程安全
            synchronized (instance) {
                if (instance == null) {
                    instance = new LazySingleton1();
                }
            }
        }

        return instance;
    }

    /**
     * 通过重新该方法防止反序列化时返回不同的实例
     * @return
     */
    public Object readResolve() {
        return instance;
    }
}
