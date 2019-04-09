package com.guanghuan3.homework.designpattern.factory.abstractfactorymethod;

/**
 * Created by Administrator
 * 抽象工厂方法将整套的产品族归纳到一个工厂中，通过同一个工厂进行产品组不同产品的构造，
 * 方便于产品固定的情况下同时拥有构造该产品族的所有方式
 *
 * 缺点：顶层工厂接口拓展新的产品线(新增产品)，需要修改所有已经实现的工厂类添加新增的产品，违反开闭原则
 * on 2019/4/9.
 */
public class AbstractFactoryMethodTest {
    public static void main(String[] args) {
        IDigitalFactory factory = new HuaweiFactory();
        factory.createPhone().call();
        factory.createPad().play();
        factory.signal().signal();

        factory = new SamsungFactory();
        factory.createPhone().call();
        factory.createPad().play();
        try {
            factory.signal().signal();
        } catch (Exception e) {
            System.err.println("三星玩完，没有信号");
        }
    }
}
