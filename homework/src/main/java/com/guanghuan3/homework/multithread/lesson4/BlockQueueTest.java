package com.guanghuan3.homework.multithread.lesson4;

/**
 * Created by Administrator
 * on 2019/5/28.
 */
public class BlockQueueTest {

    public static void main(String[] args) {
        BlockQueue bq = new BlockQueue(5);

        new Thread(()->{
            boolean over = false;
            while (!over) {
                System.err.println("取出" + bq.take());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (bq.getCount() == 0) {
                    over = true;
                }
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 10; i ++) {
                bq.put("第["+i+"]个元素");
            }
        }).start();
    }

}
