package com.lry.factory;

import com.lry.dao.UserDao;
import com.lry.dao.impl.UserDaoImpl;

public class StaticFactory {

    public static UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
