package com.guanghuan3.homework.designpattern.delegate.strategy;

import com.guanghuan3.homework.designpattern.delegate.DelayStrategy;

/**
 * Created by Administrator
 * on 2019/4/20.
 */
public class DefaultDelayStrategy implements DelayStrategy {
    public boolean support(Object obj) {
        return true;
    }

    public int delayDays() {
        return 0;
    }
}
