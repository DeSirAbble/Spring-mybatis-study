package com.lry.service.impl;

import com.lry.dao.RoleDao;
import com.lry.dao.UserDao;
import com.lry.domain.Role;
import com.lry.domain.User;
import com.lry.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<User> list() {
        List<User> userList = userDao.findAll();
        // 封装userList中的每个User的roles数据
        for (User user : userList) {
            // 获得user 的id
            Long id = user.getId();
            // 将id作为参数，查询当前userId对应的Role集合数据
            List<Role> roles = roleDao.findRoleByUserId(id);
            user.setRoles(roles);
        }
        return userList;
    }

    @Override
    public void save(User user, Long[] roleIds) {
        // 1.向sys_user表中存储数据
        Long userId = userDao.save(user);
        // 2.向sys_user_role关系表存储多条数据
        userDao.saveUserRoleRel(userId,roleIds);
    }

    @Override
    public void del(Long userId) {
        // 1、删除sys_user_role关系表
        userDao.delUserRoleRel(userId);
        // 2.删除sys_user表对应内容
        userDao.del(userId);
    }
}
