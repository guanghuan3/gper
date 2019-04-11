package com.guanghuan3.homework.designpattern.factory.abstractfactorymethod;

import com.guanghuan3.homework.designpattern.factory.IPad;
import com.guanghuan3.homework.designpattern.factory.IPhone;
import com.guanghuan3.homework.designpattern.factory.ISignal;

/**
 * Created by Administrator
 * 抽象工厂类，默认实现IDigitalFactory的所有方法，返回空信息。
 * 具体子类继承此类，重写返回的具体产品信息。
 * 方便在多具体实现时不需要逐个修改具体实现，根据需要选择实现具体子类，不需要的则返回空
 * on 2019/4/11.
 */
public abstract class AbstractDigitalFactory implements IDigitalFactory{

    public IPhone createPhone() {
        return null;
    }

    public IPad createPad() {
        return null;
    }

    public ISignal signal() {
        return null;
    }
}
