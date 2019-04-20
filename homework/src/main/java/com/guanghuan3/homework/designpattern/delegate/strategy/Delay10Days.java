package com.guanghuan3.homework.designpattern.delegate.strategy;

import com.guanghuan3.homework.designpattern.delegate.DelayStrategy;

/**
 * Created by Administrator
 * on 2019/4/20.
 */
public class Delay10Days implements DelayStrategy {
    public boolean support(Object obj) {
        return obj != null && obj.equals(10);
    }

    public int delayDays() {
        return 10;
    }
}
