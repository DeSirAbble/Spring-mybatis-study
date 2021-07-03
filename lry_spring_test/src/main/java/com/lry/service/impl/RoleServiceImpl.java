package com.lry.service.impl;

import com.lry.dao.RoleDao;
import com.lry.domain.Role;
import com.lry.service.RoleService;
import java.util.List;

public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<Role> list() {
        List<Role> list = roleDao.findAll();
        return list;
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }
}
