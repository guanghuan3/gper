package com.guanghuan3.homework.multithread.lesson1.service.impl;

import com.guanghuan3.homework.multithread.lesson1.entity.Order;
import com.guanghuan3.homework.multithread.lesson1.service.IOrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator
 * on 2019/5/9.
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Override
    public List<Order> getOrderList(Map<String, Object> parms) {
        return null;
    }

    @Override
    public Integer updateOrderBatch(List<Order> orderList) {
        return null;
    }

    @Override
    public Integer updateOrder(Order o) {
        return null;
    }
}
