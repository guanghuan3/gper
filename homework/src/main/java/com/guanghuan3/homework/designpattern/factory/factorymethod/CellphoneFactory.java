package com.guanghuan3.homework.designpattern.factory.factorymethod;

import com.guanghuan3.homework.designpattern.factory.Cellphone;
import com.guanghuan3.homework.designpattern.factory.IPhone;

/**
 * Created by Administrator
 * on 2019/4/9.
 */
public class CellphoneFactory implements IPhoneFactory {

    /**
     * @return
     */
    public IPhone createPhone() {
        return new Cellphone();
    }
}
