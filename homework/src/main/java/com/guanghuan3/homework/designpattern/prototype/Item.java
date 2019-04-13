package com.guanghuan3.homework.designpattern.prototype;

import java.io.Serializable;

/**
 * Created by Administrator
 * on 2019/4/13.
 */
public class Item implements Cloneable, Serializable {

    private String type;

    private String name;

    private Integer sort;

    private Singer singer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer zhoujielun) {
        this.singer = zhoujielun;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 父级克隆
        Item i = (Item) super.clone();
        return i;
    }
}
