package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liuLiang
 * @create 2022/4/8 20:55
 * @email kekorand@gmail.com
 * @Description
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    @ResponseBody
    public UserEntity getUser(Integer id){
        UserEntity user = userService.getUser(id);
        return user;
    }
}
