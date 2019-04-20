package com.guanghuan3.homework.designpattern.delegate;

/**
 * Created by Administrator
 * 延迟策略，延迟多少天
 * on 2019/4/20.
 */
public interface DelayStrategy {

    boolean support(Object key);

    int delayDays();
}
