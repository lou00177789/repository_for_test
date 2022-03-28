package com.liu.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liuLiang
 * @create 2022/3/22 11:00
 * @Description
 * @explain
 */
@Controller
public class a {
    @RequestMapping("/a1")
    public String a1(){
        return "al";
    }
}
