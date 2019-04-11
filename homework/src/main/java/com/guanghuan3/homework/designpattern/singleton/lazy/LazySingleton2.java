package com.guanghuan3.homework.designpattern.singleton.lazy;

import java.io.Serializable;

/**
 * Created by Administrator
 * 静态内部类单例实现
 * on 2019/4/11.
 */
public class LazySingleton2 implements Serializable{

    private LazySingleton2(){
        if (LazySingletonHolder.instance != null) {
            throw new RuntimeException("不能构建多个实例");
        }
    }

    public static LazySingleton2 getInstance() {
        return LazySingletonHolder.instance;
    }

    private static class LazySingletonHolder {
        private static final LazySingleton2 instance = new LazySingleton2();
    }

    public Object readResolve() {
        return LazySingleton2.getInstance();
    }

}
