package com.guanghuan3.homework.multithread.lesson1.service;


import com.guanghuan3.homework.multithread.lesson1.entity.Order;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator
 * on 2019/5/9.
 */
public interface IOrderService {

    public List<Order> getOrderList(Map<String, Object> parms);

    public Integer updateOrderBatch(List<Order> orderList);

    public Integer updateOrder(Order o);
}
