package com.example.store.service;

import com.example.store.entity.Admin;
import com.example.store.entity.Order;
import com.example.store.entity.Roles;
import com.example.store.entity.User;
import com.github.pagehelper.PageInfo;

public interface OrderService {

    /**
     * 添加订单
     * @param order
     */
    public void addOrder(Order order);

    /**
     * 修改订单
     * @param order
     */
    public void updateOrder(Order order);

    /**
     * 删除订单
     * @param id
     */
    public void deleteOrder(long[] id);

    /**
     * 分页查询订单
     *
     * @param condition 查询条件
     * @return 返回查询结果
     */
    PageInfo orderQueryPage(OrderQueryCondition condition);
}
