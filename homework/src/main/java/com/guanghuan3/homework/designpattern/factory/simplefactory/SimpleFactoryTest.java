package com.guanghuan3.homework.designpattern.factory.simplefactory;

import com.guanghuan3.homework.designpattern.factory.Cellphone;
import com.guanghuan3.homework.designpattern.factory.IPhone;
import com.guanghuan3.homework.designpattern.factory.Telephone;

/**
 * Created by Administrator
 * on 2019/4/9.
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {
        testByType();

        testByClass();
    }

    public static void testByType() {
        IPhone phone = SimpleFactory.createPhoneByType(SimpleFactory.PHONE_TYPE_TELEPHONE);
        phone.call();

        phone = SimpleFactory.createPhoneByType(SimpleFactory.PHONE_TYPE_CELLPHONE);
        phone.call();
    }

    public static void testByClass() {
        IPhone phone = SimpleFactory.createPhoneByClass(Cellphone.class);
        phone.call();

        phone = SimpleFactory.createPhoneByClass(Telephone.class);
        phone.call();
    }
}
