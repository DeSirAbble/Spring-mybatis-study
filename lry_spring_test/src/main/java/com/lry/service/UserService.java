package com.lry.service;

import com.lry.domain.User;

import java.util.List;

public interface UserService {
    List<User> list();

    void save(User user,Long[] roleIds);

    void del(Long userId);
}
