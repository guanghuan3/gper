package com.guanghuan3.homework.designpattern.singleton.hungry;

/**
 * Created by Administrator
 *
 * 缺点：未使用就创建了实例，预先占用内存资源
 * on 2019/4/11.
 */
public class HungrySingleTon2 {

    // final保证当使用反射时不能篡改实例
    private static final HungrySingleTon2 INSTANCE;

    static {
        // 静态块构建实例
        INSTANCE = new HungrySingleTon2();
    }

    private HungrySingleTon2(){}

    public static HungrySingleTon2 getInstance() {
        return INSTANCE;
    }

}
