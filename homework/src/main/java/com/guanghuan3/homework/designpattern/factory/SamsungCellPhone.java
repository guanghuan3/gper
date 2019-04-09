package com.guanghuan3.homework.designpattern.factory;

/**
 * Created by Administrator
 * on 2019/4/9.
 */
public class SamsungCellPhone implements IPhone {
    public void call() {
        System.err.println("使用三星手机打电话");
    }
}
