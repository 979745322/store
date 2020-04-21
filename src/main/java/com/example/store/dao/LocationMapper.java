package com.example.store.dao;

import com.example.store.entity.Admin;
import com.example.store.entity.Location;
import com.example.store.entity.Roles;
import com.example.store.entity.User;
import com.example.store.service.LocationQueryCondition;
import com.example.store.service.UserQueryCondition;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LocationMapper {

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
    public void deleteLocation(long id);

    /**
     * 分页查询地址
     *
     * @param condition 查询条件
     * @return 返回查询结果
     */
    List<Location> locationQueryPage(LocationQueryCondition condition);

    Location selectLocationById(long id);
}
