package com.guanghuan3.homework.designpattern.prototype;

import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator
 * on 2019/4/13.
 */
public  class Tiket implements Cloneable, Serializable{

    private String tiketName;

    private String seat;

    private Date deadLine;

    private List<Item> items;

    public String getTiketName() {
        return tiketName;
    }

    public void setTiketName(String tiketName) {
        this.tiketName = tiketName;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
            // 使用字节码序列化对象后反序列化得到新的实例，深克隆
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);

            byte[] bytes = baos.toByteArray();
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
