package com.lry.factory;

import com.lry.dao.UserDao;
import com.lry.dao.impl.UserDaoImpl;

public class DynamicFactory {
    public UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
