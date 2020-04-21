package com.example.store.controller;

import com.example.store.entity.Location;
import com.example.store.entity.Order;
import com.example.store.service.LocationQueryCondition;
import com.example.store.service.OrderQueryCondition;
import com.example.store.service.OrderService;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@CrossOrigin
@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ResponseBody
    @RequestMapping("/addOrder")
    public Map<String, Object> addOrder(Order order) {
        log.info("addOrder()order:" + order.toString());
        orderService.addOrder(order);
        Map<String, Object> map = Maps.newHashMap();
        map.put("state", "success");
        return map;
    }

    @ResponseBody
    @RequestMapping("/updateOrder")
    public Map<String, Object> updateOrder(Order order) {
        log.info("updateOrder()order:" + order.toString());
        orderService.updateOrder(order);
        Map<String, Object> map = Maps.newHashMap();
        map.put("state", "success");
        return map;
    }

    @ResponseBody
    @RequestMapping("/deleteOrder")
    public Map<String, Object> deleteOrder(long[] id) {
        log.info("deleteOrder()id:" + id);
        for (long ida : id) {
            log.info("deleteOrder()id:" + ida);
        }
        orderService.deleteOrder(id);
        Map<String, Object> map = Maps.newHashMap();
        map.put("state", "success");
        return map;
    }

    @ResponseBody
    @RequestMapping("/selectOrder")
    public Map<String, Object> selectOrder(OrderQueryCondition condition) {
        log.info("selectOrder()condition:" + condition.toString());
        Map<String, Object> map = Maps.newHashMap();
        map.put("state", "success");
        map.put("pageInfo", orderService.orderQueryPage(condition));
        return map;
    }
}
