package com.example.store.dao;

import com.example.store.entity.Order;
import com.example.store.entity.Product;
import com.example.store.service.OrderQueryCondition;
import com.example.store.service.ProductQueryCondition;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {

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
    public void deleteOrder(long id);

    /**
     * 分页查询订单
     *
     * @param condition 查询条件
     * @return 返回查询结果
     */
    List<Order> orderQueryPage(OrderQueryCondition condition);
}
