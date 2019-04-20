package com.guanghuan3.homework.designpattern.delegate.strategy;

import com.guanghuan3.homework.designpattern.delegate.DelayStrategy;

/**
 * Created by Administrator
 * on 2019/4/20.
 */
public class Delay21Days implements DelayStrategy{
    public boolean support(Object obj) {
        return obj != null && obj.equals(21);
    }

    public int delayDays() {
        System.err.println("要延迟21天");
        return 21;
    }
}
