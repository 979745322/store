package com.example.store.service;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 地址分页查询条件实体
 */
@Getter
@Setter
public class LocationQueryCondition {

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
    long user_id;
    String location_default = null;
    String name = null;
    String tel = null;
    String province = null;
    String city = null;
    String region = null;
    String address = null;

    @Override
    public String toString() {
        return "LocationQueryCondition{" +
                "pageSize=" + pageSize +
                ", navigatePages=" + navigatePages +
                ", pageNum=" + pageNum +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", id=" + id +
                ", user_id=" + user_id +
                ", location_default='" + location_default + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
