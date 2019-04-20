package com.guanghuan3.homework.myspringframework.beans.support;

import com.guanghuan3.homework.myspringframework.beans.MyBeanFactory;
import org.springframework.beans.factory.BeanFactory;

/**
 * Created by Administrator
 * on 2019/4/18.
 */
public abstract class MyAbstractApplicationContext implements MyBeanFactory {

    abstract protected void refresh();
}
