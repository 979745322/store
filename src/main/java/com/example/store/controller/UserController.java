package com.example.store.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.store.entity.Admin;
import com.example.store.entity.Roles;
import com.example.store.entity.User;
import com.example.store.service.UserQueryCondition;
import com.example.store.service.UserService;
import com.example.store.utils.HttpClient;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@CrossOrigin
@org.springframework.stereotype.Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @RequestMapping("/getAuthCode")
    public Map<String, Object> getAuthCode(String js_code) {
        log.info("getAuthCode()js_code:" + js_code);
        String url = WebConstant.WX_AUTH_CODE_URL + "?appid=" + WebConstant.WX_APPID + "&secret=" + WebConstant.WX_SECRET + "&js_code=" + js_code + "&grant_type=authorization_code";
        String result = HttpClient.doGet(url);
        log.info("getAuthCode()result:" + result);
        Map<String, Object> map = Maps.newHashMap();
        JSONObject resultJson = JSON.parseObject(result);
        if (resultJson.getString("errcode") == null) {
            map.put("state", "success");
            map.put("session_key", resultJson.getString("session_key"));
            map.put("openid", resultJson.getString("openid"));
        } else {
            map.put("state", "fail");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/login")
    public Map<String, Object> login(Admin admin) {
        log.info("login()admin:" + admin.toString());
        Map<String, Object> map = Maps.newHashMap();
        String token = userService.login(admin);
        if (token != null) {
            map.put("state", "success");
            map.put("token", token);
        } else {
            map.put("state", "fail");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/selectRolesByToken")
    public Map<String, Object> selectRolesByToken(String token) {
        log.info("selectRolesByToken()token:" + token);
        Map<String, Object> map = Maps.newHashMap();
        Roles roles = userService.selectRolesByToken(token);
        if (roles != null) {
            map.put("state", "success");
            map.put("roles", roles);
        } else {
            map.put("state", "fail");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/addUser")
    public Map<String, Object> addUser(User user) {
        log.info("addUser()user:" + user.toString());
        userService.addUser(user);
        Map<String, Object> map = Maps.newHashMap();
        map.put("state", "success");
        return map;
    }

    @ResponseBody
    @RequestMapping("/updateUser")
    public Map<String, Object> updateUser(User user) {
        log.info("updateUser()user:" + user.toString());
        userService.updateUser(user);
        Map<String, Object> map = Maps.newHashMap();
        map.put("state", "success");
        return map;
    }

    @ResponseBody
    @RequestMapping("/deleteUser")
    public Map<String, Object> deleteUser(long[] id) {
        log.info("deleteUser()id:" + id);
        for (long ida : id) {
            log.info("deleteUser()id:" + ida);
        }
        userService.deleteUser(id);
        Map<String, Object> map = Maps.newHashMap();
        map.put("state", "success");
        return map;
    }

    @ResponseBody
    @RequestMapping("/selectUser")
    public Map<String, Object> selectUser(UserQueryCondition condition) {
        log.info("selectUser()condition:" + condition.toString());
        Map<String, Object> map = Maps.newHashMap();
        map.put("state", "success");
        map.put("pageInfo", userService.userQueryPage(condition));
        return map;
    }

}
