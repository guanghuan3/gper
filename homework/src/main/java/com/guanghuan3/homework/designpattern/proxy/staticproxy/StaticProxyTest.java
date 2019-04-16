package com.guanghuan3.homework.designpattern.proxy.staticproxy;

import com.guanghuan3.homework.designpattern.proxy.HouseMaster;
import com.guanghuan3.homework.designpattern.proxy.Landlord;

/**
 * Created by Administrator
 *
 * 静态代理
 * 在被代理的目标对象执行操作的前后进行加强
 *
 * 缺点：
 * 1、当被代理的对象类型增加时需要新增加对应的代理对象，量大时去实现工作量直接爆炸
 * 2、当被代理对象可执行的操作增加且增强的功能一致时，代理方法需要修改代码对应增加
 * on 2019/4/16.
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        HouseMaster hm = new Landlord();

        StaticProxy proxy = new StaticProxy(hm);
        proxy.rentHouse();

        proxy.sellHouse();
    }
}
