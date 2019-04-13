package com.guanghuan3.homework.designpattern.prototype;

/**
 * Created by Administrator
 *
 * 单例，测试克隆的时候是否有效
 * on 2019/4/13.
 */
public enum Singer {

    Zhoujielun("周杰伦", "男", 38);

    private String name;

    private String gender;

    private Integer age;

    Singer(String name, String gender, Integer age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
