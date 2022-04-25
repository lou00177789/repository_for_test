package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @author liuLiang
 * @create 2022/4/8 20:55
 * @email kekorand@gmail.com
 * @Description
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public UserEntity getUser(Integer id) {
        return userDao.getUser(id);
    }
}
