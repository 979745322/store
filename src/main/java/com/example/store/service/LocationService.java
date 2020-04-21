package com.example.store.service;

import com.example.store.entity.Location;
import com.github.pagehelper.PageInfo;

public interface LocationService {

    /**
     * 添加地址
     * @param location
     */
    public void addLocation(Location location);

    /**
     * 修改地址
     * @param location
     */
    public void updateLocation(Location location);

    /**
     * 删除地址
     * @param id
     */
    public void deleteLocation(long[] id);

    /**
     * 分页查询地址
     *
     * @param condition 查询条件
     * @return 返回查询结果
     */
    PageInfo locationQueryPage(LocationQueryCondition condition);
}
