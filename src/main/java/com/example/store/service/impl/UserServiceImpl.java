package com.example.store.service.impl;

import com.example.store.dao.UserMapper;
import com.example.store.entity.Admin;
import com.example.store.entity.Roles;
import com.example.store.entity.User;
import com.example.store.service.UserQueryCondition;
import com.example.store.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public String login(Admin admin) {
        return userMapper.login(admin);
    }

    @Override
    public Roles selectRolesByToken(String token) {
        return userMapper.selectRolesByToken(token);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(long[] id) {
        for (long ida:id) {
            userMapper.deleteUser(ida);
        }
    }

    @Override
    public PageInfo userQueryPage(UserQueryCondition condition) {
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        final List<User> list = userMapper.userQueryPage(condition);
        return new PageInfo(list, condition.getNavigatePages());
    }
}
