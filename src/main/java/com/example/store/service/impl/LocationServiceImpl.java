package com.example.store.service.impl;

import com.example.store.dao.LocationMapper;
import com.example.store.entity.Location;
import com.example.store.service.LocationQueryCondition;
import com.example.store.service.LocationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationMapper locationMapper;

    @Autowired
    public LocationServiceImpl(LocationMapper locationMapper) {
        this.locationMapper = locationMapper;
    }

    @Override
    public void addLocation(Location location) {
        locationMapper.addLocation(location);
    }

    @Override
    public void updateLocation(Location location) {
        locationMapper.updateLocation(location);
    }

    @Override
    public void deleteLocation(long[] id) {
        for (long ida:id) {
            locationMapper.deleteLocation(ida);
        }
    }

    @Override
    public PageInfo locationQueryPage(LocationQueryCondition condition) {
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        final List<Location> list = locationMapper.locationQueryPage(condition);
        return new PageInfo(list, condition.getNavigatePages());
    }
}
