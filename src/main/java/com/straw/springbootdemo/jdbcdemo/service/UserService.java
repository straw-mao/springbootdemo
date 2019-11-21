package com.straw.springbootdemo.jdbcdemo.service;

import com.straw.springbootdemo.jdbcdemo.dao.UserDao;
import com.straw.springbootdemo.jdbcdemo.entity.UserEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ Author : straw
 * @ Date   : 2019/11/21 18:31
 * @ Desc   :
 */
@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public int add(UserEntity user) {
        return userDao.add(user);
    }

    public int update(UserEntity user) {
        return userDao.update(user);
    }

    public int deleteById(String id) {
        return userDao.deleteById(id);
    }

    public UserEntity getUserById(String id) {
        return userDao.getUserById(id);
    }

    public List<UserEntity> findAll() {
        return userDao.findAll();
    }

}
