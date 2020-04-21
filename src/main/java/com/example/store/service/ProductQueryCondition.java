package com.example.store.service;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 商品分页查询条件实体
 */
@Getter
@Setter
public class ProductQueryCondition {

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
     * 商品id
     */
    long id;

    /**
     * 商品名称
     */
    String name = null;

    /**
     * 佣金
     */
    BigDecimal commission;

    /**
     * 价格
     */
    BigDecimal price;

    /**
     * 描述
     */
    String introduction = null;

    /**
     * 已卖出
     */
    long solid;

    /**
     * 商家id
     */
    long shop_id;

    /**
     * 库存
     */
    long inventory;

    /**
     * 旧价
     */
    BigDecimal old_price;

    /**
     * 创建时间
     */
    String startTime = null;

    /**
     * 创建时间
     */
    String endTime = null;
    /**
     * 标签
     */
    String tag = null;
    /**
     * 类型
     */
    String type = null;
    /**
     * 上架状态
     */
    String state = null;

    @Override
    public String toString() {
        return "ProductQueryCondition{" +
                "pageSize=" + pageSize +
                ", navigatePages=" + navigatePages +
                ", pageNum=" + pageNum +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", commission=" + commission +
                ", price=" + price +
                ", introduction='" + introduction + '\'' +
                ", solid=" + solid +
                ", shop_id=" + shop_id +
                ", inventory=" + inventory +
                ", old_price=" + old_price +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", tag='" + tag + '\'' +
                ", type='" + type + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
