package com.example.store.controller;

import com.example.store.entity.Location;
import com.example.store.service.LocationQueryCondition;
import com.example.store.service.LocationService;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Slf4j
@CrossOrigin
@Controller
@RequestMapping("/location")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @ResponseBody
    @RequestMapping("/addLocation")
    public Map<String, Object> addLocation(Location location) {
        log.info("addLocation()location:" + location.toString());
        locationService.addLocation(location);
        Map<String, Object> map = Maps.newHashMap();
        map.put("state", "success");
        return map;
    }

    @ResponseBody
    @RequestMapping("/updateLocation")
    public Map<String, Object> updateLocation(Location location) {
        log.info("updateLocation()location:" + location.toString());
        locationService.updateLocation(location);
        Map<String, Object> map = Maps.newHashMap();
        map.put("state", "success");
        return map;
    }

    @ResponseBody
    @RequestMapping("/deleteLocation")
    public Map<String, Object> deleteLocation(long[] id) {
        log.info("deleteLocation()id:" + id);
        for (long ida:id) {
            log.info("deleteLocation()id:" + ida);
        }
        locationService.deleteLocation(id);
        Map<String, Object> map = Maps.newHashMap();
        map.put("state", "success");
        return map;
    }

    @ResponseBody
    @RequestMapping("/selectLocation")
    public Map<String, Object> selectLocation(LocationQueryCondition condition) {
        log.info("selectLocation()condition:" + condition.toString());
        Map<String, Object> map = Maps.newHashMap();
        map.put("state", "success");
        map.put("pageInfo", locationService.locationQueryPage(condition));
        return map;
    }
}
