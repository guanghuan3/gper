package com.guanghuan3.homework.designpattern.factory.factorymethod;

import com.guanghuan3.homework.designpattern.factory.IPhone;

/**
 * Created by Administrator
 * 中间抽离一层工厂类，具体细节由子类实现处理。满足里氏替换原则
 * 不同子类具体进行创建细节处理，满足单一职责
 * 从简单工厂升级，新增业务后不修改原有方法，只需新增实现类，满足开闭原则
 *
 * 缺点：
 * 1、随着需求变化，需要增加更多的子类实现
 * 2、客户端调用需要知道有哪些具体工厂实现，违反最少知道原则
 * on 2019/4/9.
 */
public interface IPhoneFactory {

    /**
     * @return
     */
    IPhone createPhone();
}
