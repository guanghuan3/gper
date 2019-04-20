package com.guanghuan3.homework.myspringframework.beans;

/**
 * Created by Administrator
 * on 2019/4/14.
 */
public interface MyBeanFactory {

    Object getBean(String beanName);

    <T> T getBean(Class<T> clazz);

}
