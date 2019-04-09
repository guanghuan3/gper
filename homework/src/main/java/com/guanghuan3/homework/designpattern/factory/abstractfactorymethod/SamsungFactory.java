package com.guanghuan3.homework.designpattern.factory.abstractfactorymethod;

import com.guanghuan3.homework.designpattern.factory.*;

/**
 * Created by Administrator
 * on 2019/4/9.
 */
public class SamsungFactory implements IDigitalFactory {
    public IPhone createPhone() {
        return new SamsungCellPhone();
    }

    public IPad createPad() {
        return new SamsungPad();
    }

    public ISignal signal() {
        return null;
    }
}
