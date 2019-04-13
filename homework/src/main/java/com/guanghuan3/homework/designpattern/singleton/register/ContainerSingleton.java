package com.guanghuan3.homework.designpattern.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator
 *
 * 容器式注册单例模式，容器实例属于静态饿汉式单例
 * 容器中的实例在double-check的条件下使用懒汉式单例
 * on 2019/4/13.
 */
public class ContainerSingleton {

    private static Map<String, Object> container = new ConcurrentHashMap<String, Object>();

    // double-check构建实例，并将构建的实例按照classname，instance的形式保存
    public static <T> T getBean(Class<T> cls) {
        if (!container.containsKey(cls.getName())) {
            synchronized (container) {
                if (!container.containsKey(cls.getName())) {
                    try {
                        container.put(cls.getName(), cls.newInstance());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return (T) container.get(cls.getName());
    }
}
