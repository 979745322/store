package com.example.store.dao;

import com.example.store.entity.Admin;
import com.example.store.entity.Roles;
import com.example.store.entity.User;
import com.example.store.service.UserQueryCondition;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

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
    public void deleteUser(long id);


    /**
     * 分页查询用户
     *
     * @param condition 查询条件
     * @return 返回查询结果
     */
    List<User> userQueryPage(UserQueryCondition condition);

    User selectUserById(long id);
}
