package com.guanghuan3.homework.designpattern.proxy.dynamicproxy.jdkproxy;

import com.guanghuan3.homework.designpattern.proxy.HouseMaster;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator
 * on 2019/4/16.
 */
public class JDKProxy implements InvocationHandler{

    private HouseMaster target;

    public JDKProxy(HouseMaster target) {
        this.target = target;
    }

    public HouseMaster getProxy() {
        HouseMaster proxy = (HouseMaster) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), new Class[]{HouseMaster.class}, this);
        return proxy;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.err.println("JDK动态代理：动态收费增加10%");

        Object obj = method.invoke(target, args);

        System.err.println("JDK动态代理：房产中介赚取差价10%");

        return obj;
    }
}
