package com.guanghuan3.homework.designpattern.proxy.dynamicproxy.jdkproxy;

import com.guanghuan3.homework.designpattern.proxy.HouseMaster;
import com.guanghuan3.homework.designpattern.proxy.Landlord;

/**
 * Created by Administrator
 *
 * 1、依赖被代理类实现的接口，否则不能动态代理
 * 2、动态生成被代理类实现接口的字节码实现
 * 3、生成的字节码实现类中保存了目标代理的实例，通过在生成的字节码实现类的方法中调用目标代理类的方法，在其调用前后增强调用
 *
 * 对比cglib，都是重新生成字节码文件
 * 1、jdk动态代理是实现接口并持有目标对象的引用，cglib是继承代理类
 * 2、JDK动态代理调用目标类的方法，并在其前后增强；CGLIB是继承目标类，重写执行的方法，所以目标类的final方法代理不了
 * 3、jdk动态代理调用方法时每次使用的反射，cglib调用的是继承目标类并重写后的自己的方法，所以调用时cglib性能由于jdk
 * 4、由于cglib生成字节码时重写目标类方法，所以jdk在生成字节码时性能由于cglib
 * on 2019/4/16.
 */
public class JDKProxyTest {

    public static void main(String[] args) {
        HouseMaster master = new JDKProxy(new Landlord()).getProxy();

        master.sellHouse();

        master.rentHouse();

        master.decorate();
    }
}
