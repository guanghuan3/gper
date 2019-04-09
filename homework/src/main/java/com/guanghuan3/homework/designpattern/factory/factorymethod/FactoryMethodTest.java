package com.guanghuan3.homework.designpattern.factory.factorymethod;

import com.guanghuan3.homework.designpattern.factory.IPhone;

/**
 * Created by Administrator
 * on 2019/4/9.
 */
public class FactoryMethodTest {

    public static void main(String[] args) {
        // 需要客户端显式创建工厂，违反最少知道原则
        IPhoneFactory factory = new TelephoneFactory();
        IPhone phone = factory.createPhone();
        phone.call();

        factory = new CellphoneFactory();
        phone = factory.createPhone();
        phone.call();
    }
}
