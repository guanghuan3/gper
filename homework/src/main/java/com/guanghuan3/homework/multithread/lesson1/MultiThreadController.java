package com.guanghuan3.homework.multithread.lesson1;

import com.guanghuan3.homework.multithread.lesson1.entity.Order;
import com.guanghuan3.homework.multithread.lesson1.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator
 * on 2019/5/9.
 */
@Controller
public class MultiThreadController {

    @Autowired
    private IOrderService orderServiceImpl;

    @RequestMapping("synchronize")
    public String sychronize(HttpServletRequest request, HttpServletResponse response) {

        // TODO 1、根据ID查询数据库工单信息， 2、根据存在的工单信息判断工单状态是否是待处理，3、更新工单信息并入库
        List<Order> orderList = doGetOrderList(request);

        doCheckAndUpdateOrder(orderList);

        return "请求成功";
    }

    @RequestMapping("asynchronize")
    public String asynchronize(HttpServletRequest request, HttpServletResponse response) {

        // TODO 1、根据ID查询数据库工单信息， 2、根据存在的工单信息判断工单状态是否是待处理，3、更新工单信息并入库
        Thread t = new Thread(() -> {
            List<Order> orderList = doGetOrderList(request);

            doCheckAndUpdateOrder(orderList);
        });
        t.start();

        return "请求成功";
    }

    private List<Order> doGetOrderList(HttpServletRequest request) {

        String ids = request.getParameter("ids");
        Map<String, Object> params = new HashMap<>();
        params.put("ids", ids);

        List<Order> orderList = orderServiceImpl.getOrderList(params);
        return orderList;
    }

    private void doCheckAndUpdateOrder(List<Order> orderList) {
        if (orderList != null && orderList.size() > 0) {
            for (Order o : orderList) {
                // 未处理
                if ("0".equals(o.getStatus())) {
                    doUpdate(o);
                }
            }
        }
    }

    private void doUpdate(Order o) {
        if (o != null) {
            // 1=已处理
            o.setStatus("1");
            orderServiceImpl.updateOrder(o);
        }
    }

}
