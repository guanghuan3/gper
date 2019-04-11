package com.guanghuan3.homework.designpattern.factory.abstractfactorymethod;

import com.guanghuan3.homework.designpattern.factory.*;

/**
 * Created by Administrator
 * on 2019/4/9.
 */
public class HuaweiFactory extends AbstractDigitalFactory {
    public IPhone createPhone() {
        return new HuaweiCellPhone();
    }

    public IPad createPad() {
        return new HuaweiPad();
    }

    public ISignal signal() {
        return new HuaweiFiveGSignal();
    }
}
