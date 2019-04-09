package com.guanghuan3.homework.designpattern.factory.simplefactory;

import com.guanghuan3.homework.designpattern.factory.Cellphone;
import com.guanghuan3.homework.designpattern.factory.IPhone;
import com.guanghuan3.homework.designpattern.factory.Telephone;

/**
 * Created by Administrator
 * 不论创建什么目标对象，创建方式如何，都由此工厂统一创建（违反单一职责原则）
 * on 2019/4/9.
 */
public class SimpleFactory {

    public static final String PHONE_TYPE_TELEPHONE = "telephone";

    public static final String PHONE_TYPE_CELLPHONE = "cellphone";

    /**
     * 1、不易拓展，增加类型则需要修改源代码(违反开闭原则)
     * 2、调用方（客户端）传递参数无法有效控制，容易发生系统错误
     * @param phoneType
     * @return
     */
    public static IPhone createPhoneByType(String phoneType) {
        IPhone phone = null;

        if (PHONE_TYPE_TELEPHONE.equals(phoneType)) {
            phone = new Telephone();
        } else if (PHONE_TYPE_CELLPHONE.equals(phoneType)) {
            phone = new Cellphone();
        }

        return phone;
    }

    /**
     * 调用方（客户端）传递入参需要知道可用的类型(违反最少知道原则)
     * @param phoneClass
     * @return
     */
    public static <T> T createPhoneByClass(Class<T> phoneClass) {
        T phone = null;

        if (phoneClass != null) {
            try {
                phone = phoneClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return phone;
    }

}
