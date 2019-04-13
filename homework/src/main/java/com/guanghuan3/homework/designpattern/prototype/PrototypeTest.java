package com.guanghuan3.homework.designpattern.prototype;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Administrator
 * on 2019/4/13.
 */
public class PrototypeTest {

    public static void main(String[] args) {
        try {
            Tiket t = new Tiket();
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, 2);

            t.setDeadLine(cal.getTime());
            t.setSeat("5排6座");
            t.setTiketName("周杰伦演唱会");

            Player zhoujielun = new Player();
            zhoujielun.setName("周杰伦");
            zhoujielun.setAge(37);
            zhoujielun.setGender("男");

            List<Item> items = new ArrayList<Item>();
            Item i = new Item();
            i.setType("流行歌曲");
            i.setName("星晴");
            i.setSort(1);
            i.setSinger(Singer.Zhoujielun);
            items.add(i);

            i = (Item) i.clone();
            i.setName("牛仔很忙");
            i.setSort(2);
            items.add(i);

            t.setItems(items);
            Tiket t2 = (Tiket) t.clone();
            t2.setSeat("4排5座");
            System.err.println("t1=" + t + "，t2="+t2 + "，t1==t2" + (t == t2));
            System.err.println("t1.getItems()=" + t.getItems() + "，t2.getItems()="+t2.getItems() + "，t1==t2" + (t.getItems() == t2.getItems()));
            System.err.println("t1.items0=" + t + "，t2.items0="+t2 + "，t1==t2" + (t.getItems().get(0) == t2.getItems().get(0)));
            System.err.println("t1.items1=" + t + "，t2.items1="+t2 + "，t1==t2" + (t.getItems().get(1) == t2.getItems().get(1)));
            System.err.println(t.getSeat() + ", " + t2.getSeat());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
