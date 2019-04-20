package com.guanghuan3.homework.myspringframework.context;

import com.guanghuan3.homework.myspringframework.beans.MyBeanFactory;
import com.guanghuan3.homework.myspringframework.beans.MyBeanWrapper;
import com.guanghuan3.homework.myspringframework.beans.config.MyBeanDefinition;
import com.guanghuan3.homework.myspringframework.beans.support.MyBeanDefinitionReader;
import com.guanghuan3.homework.myspringframework.beans.support.MyDefaultListableBeanFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public MyApplicationContext(String... locations) {
        this.configLocations = locations;
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
        Map<String, MyBeanDefinition> beanDefinitionMap = super.getBeanDefinitionMap();
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
                super.getBeanDefinitionMap().put(bd.getFactoryBeanName(), bd);
            }
        }
    }

    /**
     * 对于初始化与注入两步，先完成初始化，再进行注入，避免两个类之间的循环注入
     * @param beanName
     * @return
     */
    public Object getBean(String beanName) {
        // 1、初始化
        instantialBean(beanName, super.getBeanDefinitionMap().get(beanName));

        // 2、注入
        polulateBean(beanName, new MyBeanWrapper());
        
        return null;
    }

    private void polulateBean(String beanName, MyBeanWrapper myBeanWrapper) {
    }

    private void instantialBean(String beanName, MyBeanDefinition myBeanDefinition) {
    }
}
