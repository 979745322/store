package com.example.store.service;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 图片分页查询条件实体
 */
@Getter
@Setter
public class ImageQueryCondition {

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
     * 图片id
     */
    long id;

    /**
     * 商品id
     */
    long product_id;

    /**
     * 图片名称
     */
    String name = null;

    /**
     * 图片链接
     */
    String url = null;

    /**
     * 创建时间
     */
    String startTime = null;

    /**
     * 创建时间
     */
    String endTime = null;

    @Override
    public String toString() {
        return "ImageQueryCondition{" +
                "pageSize=" + pageSize +
                ", navigatePages=" + navigatePages +
                ", pageNum=" + pageNum +
                ", id=" + id +
                ", product_id=" + product_id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
