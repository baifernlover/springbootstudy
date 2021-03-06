package com.study.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.demo.dao.UserDao;
import com.study.demo.model.UserDomain;

import com.study.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public int addUser(UserDomain user)
    {
        return userDao.insert(user);
    }
    @Override
    public PageInfo<UserDomain> findAllUser(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<UserDomain> userDomains = userDao.selectUsers();
        PageInfo result = new PageInfo(userDomains);
        return result;
    }
    @Override
    public  UserDomain findByUserName(String userName){

        UserDomain userDomains = userDao.findByUserName(userName);
        return userDomains;
    }
}
