package com.example.store.service;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 用户分页查询条件实体
 */
@Getter
@Setter
public class UserQueryCondition {

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
    String tel = null;
    /**
     * 微信id
     */
    String wechat_id = null;
    String state = null;
    /**
     * 佣金
     */
    BigDecimal commission = null;

    @Override
    public String toString() {
        return "UserQueryCondition{" +
                "pageSize=" + pageSize +
                ", navigatePages=" + navigatePages +
                ", pageNum=" + pageNum +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", id=" + id +
                ", tel='" + tel + '\'' +
                ", wechat_id='" + wechat_id + '\'' +
                ", state='" + state + '\'' +
                ", commission=" + commission +
                '}';
    }
}
