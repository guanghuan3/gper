package com.guanghuan3.homework.designpattern.proxy.staticproxy;

import com.guanghuan3.homework.designpattern.proxy.HouseMaster;

/**
 * Created by Administrator
 *
 * 中介代理
 * on 2019/4/16.
 */
public class StaticProxy implements HouseMaster {

    private HouseMaster target;

    public StaticProxy(HouseMaster master) {
        this.target = master;
    }


    public void sellHouse() {
        System.err.println("代理接手房东卖房，由代理卖房开始，代理收取10%手续费");
        target.sellHouse();
        System.err.println("代理接手房东卖房，由代理卖房结束，房价上涨10%");
    }

    public void rentHouse() {
        System.err.println("代理接手房东出粗，由代理出租加20%");
        target.rentHouse();
        System.err.println("代理接手房东出粗，由代理出租结束，代理收取了20%手续费");
    }
}
