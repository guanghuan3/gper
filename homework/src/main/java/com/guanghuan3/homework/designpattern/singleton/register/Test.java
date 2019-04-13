package com.guanghuan3.homework.designpattern.singleton.register;

/**
 * Created by Administrator
 * on 2019/4/13.
 */
public class Test {
    private String name;

    private String age;

    public Test(){}

    public Test(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name : " + name + ", age = " + age;
    }
}
