package com.guanghuan3.homework.myspringframework.context;

import com.guanghuan3.homework.myspringframework.annotation.MyAutowired;
import com.guanghuan3.homework.myspringframework.annotation.MyController;
import com.guanghuan3.homework.myspringframework.annotation.MyService;
import com.guanghuan3.homework.myspringframework.beans.MyBeanFactory;
import com.guanghuan3.homework.myspringframework.beans.MyBeanWrapper;
import com.guanghuan3.homework.myspringframework.beans.config.MyBeanDefinition;
import com.guanghuan3.homework.myspringframework.beans.support.MyBeanDefinitionReader;
import com.guanghuan3.homework.myspringframework.beans.support.MyDefaultListableBeanFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator
 *
 * 限定只做一种ApplicationContext，理论上有很多
 * 只做一种的话简单点可以只去实现DefaultListableBeanFactory
 * on 2019/4/18.
 */
public class MyApplicationContext extends MyDefaultListableBeanFactory implements MyBeanFactory {

    private String[] configLocations;

    private MyBeanDefinitionReader reader;

    private List<MyBeanDefinition> beanDefinitionsList = new ArrayList<MyBeanDefinition>();

    // 真正的单例容器
    private Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    // 存放所有beanWrapper实例
    private Map<String, MyBeanWrapper> factoryBeanInstanceCache = new ConcurrentHashMap<>();

    public MyApplicationContext(String... locations) {
        this.configLocations = locations;
        refresh();
    }

    public void refresh() {
        // 1、定位，读取配置文件
        reader = new MyBeanDefinitionReader(configLocations);

        // 2、加载配置，扫描配置路径下的类，封装成beanDefinition
        beanDefinitionsList = reader.loadBeanDefinitions();

        // 3、把配置信息放到容器中
        doRegissterBeanDefinition(beanDefinitionsList);

        // 4、把不是延迟加载的类提前注册
        doAutoWired();
    }

    private void doAutoWired() {
        Map<String, MyBeanDefinition> beanDefinitionMap = getBeanDefinitionMap();
        Set<String> keys = beanDefinitionMap.keySet();
        for (String key : keys) {
            if (!beanDefinitionMap.get(key).getLazyInit()) {
                // 依赖注入开始
                getBean(key);
            }
        }

    }

    private void doRegissterBeanDefinition(List<MyBeanDefinition> beanDefinitionList) {
        if (beanDefinitionList != null && beanDefinitionList.size() > 0) {
            for (MyBeanDefinition bd : beanDefinitionList) {
                getBeanDefinitionMap().put(bd.getFactoryBeanName(), bd);
            }
        }
    }

    public <T> T getBean(Class<T> clazz) {
//        return getBean();
        return null;
    }

    /**
     * 对于初始化与注入两步，先完成初始化，再进行注入，避免两个类之间的循环注入
     * @param beanName
     * @return
     */
    public Object getBean(String beanName) {
        MyBeanDefinition bd = getBeanDefinitionMap().get(beanName);

        // 1、初始化
        MyBeanWrapper wrapper = instantialBean(beanName, bd);

        // 2、注入
        polulateBean(beanName, bd, wrapper);
        
        return wrapper.getWrappedInstance();
    }

    private void polulateBean(String beanName, MyBeanDefinition beanDefinition, MyBeanWrapper beanWrapper) {
        Object instance = beanWrapper.getWrappedInstance();

        // 对注解类进行过滤，只有加了注解的才能被注入
        Class<?> cls = instance.getClass();
        if (cls.isAnnotationPresent(MyController.class) || cls.isAnnotationPresent(MyService.class)) {
            // 获取所有fields
            Field[] fields = cls.getFields();
            for (Field f : fields) {
                // 是否被MyAutowired标记
                if (f.isAnnotationPresent(MyAutowired.class)) {
                    MyAutowired anno = f.getAnnotation(MyAutowired.class);
                    String autowiredName = anno.name();

                    if (autowiredName == null || "".equals(autowiredName)) {
                        // 如果没有指定注入的bean的名字，默认使用字段的类名
                        autowiredName = f.getType().getName();
                    }

                    // 设置强制访问
                    f.setAccessible(true);

                    try {
                        if (factoryBeanInstanceCache.get(autowiredName) == null) {
                            continue;
                        }
                        f.set(instance, factoryBeanInstanceCache.get(autowiredName).getWrappedInstance());
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private MyBeanWrapper instantialBean(String beanName, MyBeanDefinition beanDefinition) {
        // 1、拿到被实例化的对象的类名
        String className = beanDefinition.getBeanClassName();

        // 2、进行反射实例化
        Object instance = null;
        Class<?> clazz = null;
        try {
            if (singletonObjects.containsKey(className)) {
                instance = singletonObjects.get(className);
                clazz = instance.getClass();
            } else {
                clazz = Class.forName(className);
                instance = clazz.newInstance();

                singletonObjects.put(className, instance);
                singletonObjects.put(beanDefinition.getFactoryBeanName(), instance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 3、把实例化对象封装到beanWrapper中
        MyBeanWrapper wrapper = factoryBeanInstanceCache.get(beanName);
        if (wrapper == null) {
            wrapper = new MyBeanWrapper(instance, clazz);
            // 4、把wrapper保存到ioc容器中
            // factoryBeanInstanceCache.put(className, wrapper);
            factoryBeanInstanceCache.put(beanName, wrapper);
        }

        return wrapper;
    }

    public static void main(String[] args) {
        MyApplicationContext context = new MyApplicationContext("classpath:application.properties");

        System.err.println(context.getBean("myTestController"));

//        System.err.println(context.factoryBeanInstanceCache);
//        System.err.println(context.beanDefinitionsList);
//        System.err.println(context.singletonObjects);
    }
}
