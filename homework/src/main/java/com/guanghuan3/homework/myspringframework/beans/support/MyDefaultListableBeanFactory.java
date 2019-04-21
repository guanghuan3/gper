package com.guanghuan3.homework.myspringframework.beans.support;

import com.guanghuan3.homework.myspringframework.beans.config.MyBeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator
 *
 * BeanFactory的默认实现
 * on 2019/4/18.
 */
public class MyDefaultListableBeanFactory extends MyAbstractApplicationContext {

    private final Map<String, MyBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, MyBeanDefinition>();

    public void refresh() {

    }

    public Object getBean(String beanName) {
        return null;
    }

    public <T> T getBean(Class<T> clazz) {
        return null;
    }

    protected Map<String, MyBeanDefinition> getBeanDefinitionMap() {
        return beanDefinitionMap;
    }

    /**
     * 清空
     */
    protected void destroyBeans() {
        beanDefinitionMap.clear();
    }
}
