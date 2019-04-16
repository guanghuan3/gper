package com.guanghuan3.homework.designpattern.proxy.dynamicproxy.cglibproxy;

import com.guanghuan3.homework.designpattern.proxy.Company;

/**
 * Cglib针对类进行代理，需要有继承关系
 * 动态生成的字节码重写继承的父类的方法
 *
 * 1、被代理的目标类无需实现接口
 * 2、需要被代理的父类的方法不能使用final修饰
 * Created by Administrator
 * on 2019/4/16.
 */
public class CglibProxyTest {

    public static void main(String[] args) {
        Company company = (Company) new CglibProxy().getProxy(Company.class);
        company.build();
    }
}
