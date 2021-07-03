package com.lry.mapper;

import com.lry.domain.Account;

import java.util.List;

public interface AccountMapper {


    public void save(Account account);

    public List<Account> findAll();
}
