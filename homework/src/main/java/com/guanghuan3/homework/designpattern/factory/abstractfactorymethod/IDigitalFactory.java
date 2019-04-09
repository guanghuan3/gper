package com.guanghuan3.homework.designpattern.factory.abstractfactorymethod;

import com.guanghuan3.homework.designpattern.factory.IPad;
import com.guanghuan3.homework.designpattern.factory.IPhone;
import com.guanghuan3.homework.designpattern.factory.ISignal;

/**
 * Created by Administrator
 * 每一个共产方法都满足单一职责
 * on 2019/4/9.
 */
public interface IDigitalFactory {
    
    IPhone createPhone();
    
    IPad createPad();

    ISignal signal();
}
