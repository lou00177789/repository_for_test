package com.liu.test1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liuLiang
 * @create 2022/3/22 11:05
 * @Description
 * @explain
 */
@Controller
public class b {
    @RequestMapping("b1")
    public String b1(){
        Logger logger = LoggerFactory.getLogger(b.class);
        return "b1";
    }
}
