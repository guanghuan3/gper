package com.guanghuan3.homework.designpattern.factory.abstractfactorymethod;

import com.guanghuan3.homework.designpattern.factory.*;

/**
 * Created by Administrator
 * on 2019/4/9.
 */
public class SamsungFactory extends AbstractDigitalFactory {

    public IPhone createPhone() {
        return new SamsungCellPhone();
    }

    public IPad createPad() {
        return new SamsungPad();
    }
}
