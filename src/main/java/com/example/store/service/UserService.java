package com.example.store.service;

import com.example.store.entity.Admin;
import com.example.store.entity.Roles;
import com.example.store.entity.User;
import com.github.pagehelper.PageInfo;

public interface UserService {
    /**
     * 登录
     * @param admin
     * @return
     */
    public String login(Admin admin);

    /**
     * 根据id查询权限信息
     * @param token
     * @return
     */
    public Roles selectRolesByToken(String token);

    /**
     * 添加用户
     * @param user
     */
    public void addUser(User user);

    /**
     * 修改用户
     * @param user
     */
    public void updateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    public void deleteUser(long[] id);

    /**
     * 分页查询用户
     *
     * @param condition 查询条件
     * @return 返回查询结果
     */
    PageInfo userQueryPage(UserQueryCondition condition);
}
