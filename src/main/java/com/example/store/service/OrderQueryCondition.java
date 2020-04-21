package com.example.store.service;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 订单分页查询条件实体
 */
@Getter
@Setter
public class OrderQueryCondition {

    /**
     * 每页个数
     */
    Integer pageSize;

    /**
     * 最大页数
     */
    final Integer navigatePages = 6;

    /**
     * 页数
     */
    Integer pageNum;

    /**
     * 创建时间
     */
    String startTime = null;

    /**
     * 创建时间
     */
    String endTime = null;

    long id;
    String order_id  = null;
    long user_id;
    String promoter = null;
    BigDecimal commission;
    long num;
    BigDecimal total_price;
    long product_id;
    long location_id;
    String create_time = null;
    String state = null;
    String delete_state = null;

    @Override
    public String toString() {
        return "OrderQueryCondition{" +
                "pageSize=" + pageSize +
                ", navigatePages=" + navigatePages +
                ", pageNum=" + pageNum +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", id=" + id +
                ", order_id='" + order_id + '\'' +
                ", user_id=" + user_id +
                ", promoter='" + promoter + '\'' +
                ", commission=" + commission +
                ", num=" + num +
                ", total_price=" + total_price +
                ", product_id=" + product_id +
                ", location_id=" + location_id +
                ", create_time='" + create_time + '\'' +
                ", state='" + state + '\'' +
                ", delete_state='" + delete_state + '\'' +
                '}';
    }
}
