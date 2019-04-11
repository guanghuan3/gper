package com.guanghuan3.homework.designpattern.singleton.hungry;

/**
 * Created by Administrator
 *
 * 缺点：未使用就创建了实例，预先占用内存资源
 * on 2019/4/11.
 */
public class HungrySingleTon1 {

    // 静态属性构建实例
    private static final HungrySingleTon1 INSTANCE = new HungrySingleTon1();

    private HungrySingleTon1(){}

    public static HungrySingleTon1 getInstance() {
        return INSTANCE;
    }

}
