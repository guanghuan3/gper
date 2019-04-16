package com.guanghuan3.homework.designpattern.proxy.staticproxy;

/**
 * Created by Administrator
 *
 * 静态代理
 * 在被代理的目标对象执行操作的前后进行加强
 *
 * 缺点：当被代理的对象类型增加时需要新增加对应的代理对象，量大时去实现工作量直接爆炸
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
