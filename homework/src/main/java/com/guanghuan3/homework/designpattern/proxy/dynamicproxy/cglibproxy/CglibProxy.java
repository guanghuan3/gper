package com.guanghuan3.homework.designpattern.proxy.dynamicproxy.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Administrator
 * on 2019/4/16.
 */
public class CglibProxy implements MethodInterceptor {


    public Object getProxy(Class clazz) {
        // 构建增强器
        Enhancer enhancer = new Enhancer();
        // 被代理对象的类型/目标对象的类型
        enhancer.setSuperclass(clazz);
        // 设置代理回调方法
        enhancer.setCallback(this);
        // 构建代理
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.err.println("Cglib动态代理：收取10%手续费");

        Object obj = methodProxy.invokeSuper(o, objects);

        System.err.println("Cglib动态代理：房价上涨10%");
        return obj;
    }
}
