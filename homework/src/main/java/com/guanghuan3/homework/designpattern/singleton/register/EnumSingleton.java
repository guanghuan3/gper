package com.guanghuan3.homework.designpattern.singleton.register;

/**
 * Created by Administrator
 *
 * 枚举式单例底层结构为枚举式单例，创建方式属于懒汉式单例
 * 1、美剧类构造方法默认private修饰，
 * 2、枚举类在编译期会默认有一个包含两个参数的构造方法，参数列表为class和int
 * 2、在源代码被编译时会默认静态块中实例化枚举的实例，为懒汉式单例实现
 * 3、从jdk层面防止反序列化时破坏单例实现
 *
 * 缺点
 * on 2019/4/13.
 */
public enum EnumSingleton {

    /**
     * 枚举类在声明对象实例时必须指定好实例化的数据，防止使用时被篡改
     */
    INSTANCE(new Test("zhangsan"));

    private Test obj;

    // 默认private修饰，不显示private修饰也没关系
    private EnumSingleton(Test target) {
        this.obj = target;
    }

    // 获取单例实例
    public static EnumSingleton getInstance() {
        return INSTANCE;
    }

    // 获取单例保存的值对象
    public static Test getObj() {
        return INSTANCE.obj;
    }
}
