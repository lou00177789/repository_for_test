package com.example.demo.dao;

import com.example.demo.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * @author liuLiang
 * @create 2022/4/8 20:55
 * @email kekorand@gmail.com
 * @Description
 */
@Repository
public class UserDao {
    public UserEntity getUser(Integer id) {
        System.out.println(id);
        return new UserEntity("张三",78);
    }
}
