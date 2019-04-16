package com.guanghuan3.homework.designpattern.proxy;

/**
 * Created by Administrator
 *
 * 房子主人
 * on 2019/4/16.
 */
public interface HouseMaster {

    void sellHouse();

    void rentHouse();

    /**
     * 动态新增可执行操作
     * 静态代理与动态代理实现上的差距体现
      */
    void decorate();
}
