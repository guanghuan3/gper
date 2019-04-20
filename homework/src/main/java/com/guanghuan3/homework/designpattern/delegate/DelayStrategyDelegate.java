package com.guanghuan3.homework.designpattern.delegate;

import com.guanghuan3.homework.designpattern.delegate.strategy.DefaultDelayStrategy;

import java.util.List;

/**
 * Created by Administrator
 * on 2019/4/20.
 */
public class DelayStrategyDelegate {

    private List<DelayStrategy> delayStrategies;

    public DelayStrategyDelegate(List<DelayStrategy> delayStrategies) {
        this.delayStrategies = delayStrategies;
    }

    public int doDelay(Object obj) {
        for (DelayStrategy strategy : delayStrategies) {
            if (strategy.support(obj)) {
                return strategy.delayDays();
            }
        }
        return new DefaultDelayStrategy().delayDays();
    }

}
