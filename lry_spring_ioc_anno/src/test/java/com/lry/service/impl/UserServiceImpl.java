package com.lry.service.impl;

import com.lry.dao.UserDao;
import com.lry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//<bean id="userService" class="com.lry.service.impl.UserServiceImpl"> </bean>
//@Component("userService")
@Service("userService")
@Scope("prototype")
public class UserServiceImpl implements UserService {

    @Value("${jdbc.driver}")
    private String driver;

    //<property name="userDao" ref="userDao"></property>
    @Autowired  // 按照数据类型从spring容器进行匹配
    //@Qualifier("userDao")     //是按照id名称从容器中进行匹配 但此处@Qualifier结合@Autowired一起使用
    //@Resource(name="userDao") 相当于@Autowiredh+@Qualifier
    private UserDao userDao;

//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }


    public void save() {
        System.out.println(driver);
        userDao.save();
    }

    @PostConstruct
    public void init() {
        System.out.println("对象的初始化方法");
    }

    @PreDestroy
    public void destory() {
        System.out.println("对象的销毁方法");
    }
}
