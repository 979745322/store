package com.example.store.service.impl;

import com.example.store.dao.LocationMapper;
import com.example.store.dao.OrderMapper;
import com.example.store.dao.ProductMapper;
import com.example.store.dao.UserMapper;
import com.example.store.entity.Order;
import com.example.store.entity.Product;
import com.example.store.entity.User;
import com.example.store.service.OrderQueryCondition;
import com.example.store.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;
    private final UserMapper userMapper;
    private final LocationMapper locationMapper;
    private final ProductMapper productMapper;

    @Autowired
    public OrderServiceImpl(OrderMapper orderMapper, UserMapper userMapper, LocationMapper locationMapper, ProductMapper productMapper) {
        this.orderMapper = orderMapper;
        this.userMapper = userMapper;
        this.locationMapper = locationMapper;
        this.productMapper = productMapper;
    }

    @Override
    public void addOrder(Order order) {
        Product product = productMapper.selectProjectById(order.getProduct_id());
        if(order.getPromoter()!=null&&!order.getPromoter().equals("")&&!order.getPromoter().equals("null")){
            BigDecimal commission = product.getCommission();
            commission = commission.multiply(new BigDecimal(order.getNum()));
            order.setCommission(commission);
        }else{
            order.setCommission(BigDecimal.valueOf(0));
        }
        order.setTotal_price(product.getPrice().multiply(new BigDecimal(order.getNum())));
        orderMapper.addOrder(order);
    }

    @Override
    @Transactional
    public void updateOrder(Order order) {
        orderMapper.updateOrder(order);
        // 订单状态完成推广用户增加佣金
        if (order.getState().equals("")) {
            User user = userMapper.selectUserById(order.getUser_id());
            user.setCommission(user.getCommission().add(order.getCommission()));
            userMapper.updateUser(user);
        }
    }

    @Override
    public void deleteOrder(long[] id) {
        for (long ida : id) {
            orderMapper.deleteOrder(ida);
        }
    }

    @Override
    public PageInfo orderQueryPage(OrderQueryCondition condition) {
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        final List<Order> list = orderMapper.orderQueryPage(condition);
        list.forEach((ob) -> {
            ob.setLocation(locationMapper.selectLocationById(ob.getLocation_id()));
            ob.setProduct(productMapper.selectProjectById(ob.getProduct_id()));
        });
        return new PageInfo(list, condition.getNavigatePages());
    }
}
