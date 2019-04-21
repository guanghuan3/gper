package com.guanghuan3.homework.myspringframework.beans;

/**
 * Created by Administrator
 * 原始spring为接口，此处简单处理直接实现
 * on 2019/4/20.
 */
public class MyBeanWrapper {

    private Object wrapperedInstance;

    private Class<?> wrapperedClass;

    public MyBeanWrapper(Object instance) {
        this.wrapperedInstance = instance;
        this.wrapperedClass = wrapperedInstance.getClass();
    }

    public MyBeanWrapper(Object instance, Class<?> instanceClass) {
        this.wrapperedInstance = instance;
        this.wrapperedClass = instanceClass;
    }

    /**
     * Return the bean instance wrapped by this object.
     */
    public Object getWrappedInstance() {
        return this.wrapperedInstance;
    }

    /**
     * Return the type of the wrapped bean instance.
     */
    public Class<?> getWrappedClass() {
        return this.wrapperedClass;
    }
}
