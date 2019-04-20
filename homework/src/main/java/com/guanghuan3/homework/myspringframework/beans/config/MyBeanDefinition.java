package com.guanghuan3.homework.myspringframework.beans.config;

/**
 * Created by Administrator
 * on 2019/4/18.
 */
public class MyBeanDefinition {

    private Boolean lazyInit;

    private String beanClassName;

    private String factoryBeanName;

    public Boolean getLazyInit() {
        return lazyInit;
    }

    public void setLazyInit(Boolean lazyInit) {
        this.lazyInit = lazyInit;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
    }

    public String getFactoryBeanName() {
        return factoryBeanName;
    }

    public void setFactoryBeanName(String factoryBeanName) {
        this.factoryBeanName = factoryBeanName;
    }
}
