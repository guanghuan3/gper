package com.guanghuan3.homework.designpattern.factory.factorymethod;

import com.guanghuan3.homework.designpattern.factory.IPhone;
import com.guanghuan3.homework.designpattern.factory.Telephone;

/**
 * Created by Administrator
 * on 2019/4/9.
 */
public class TelephoneFactory implements IPhoneFactory {

    public IPhone createPhone() {
        return new Telephone();
    }

}
