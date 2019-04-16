package com.guanghuan3.homework.designpattern.proxy;

/**
 * Created by Administrator
 *
 * 房东
 * on 2019/4/16.
 */
public class Landlord implements HouseMaster {
    public void sellHouse() {
        System.err.println("房东卖房");
    }

    public void rentHouse() {
        System.err.println("房东租房");
    }
}
