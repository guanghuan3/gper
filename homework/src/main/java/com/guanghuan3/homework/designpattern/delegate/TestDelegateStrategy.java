package com.guanghuan3.homework.designpattern.delegate;

import com.guanghuan3.homework.designpattern.delegate.strategy.DefaultDelayStrategy;
import com.guanghuan3.homework.designpattern.delegate.strategy.Delay10Days;
import com.guanghuan3.homework.designpattern.delegate.strategy.Delay21Days;
import com.guanghuan3.homework.designpattern.delegate.strategy.Delay7Days;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator
 * on 2019/4/20.
 */
public class TestDelegateStrategy {

    public static void main(String[] args) {
        List<DelayStrategy> strategies = initStrategy();
        DelayStrategyDelegate delegate = new DelayStrategyDelegate(strategies);

        System.err.println("延迟" + delegate.doDelay(4) + "天");

    }

    private static List<DelayStrategy> initStrategy() {
        List<DelayStrategy> strategies = new ArrayList<DelayStrategy>();

        strategies.add(new Delay7Days());
        strategies.add(new Delay10Days());
        strategies.add(new Delay21Days());
        strategies.add(new DefaultDelayStrategy());

        return strategies;

    }

}
