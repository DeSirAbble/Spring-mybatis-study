package com.lry.service.impl;

import com.lry.domain.Account;
import com.lry.mapper.AccountMapper;
import com.lry.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Override
    public void save(Account account) {
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
            mapper.save(account);

            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Account> findAll() {
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
            List<Account> accountList = mapper.findAll();
            sqlSession.close();
            return accountList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
