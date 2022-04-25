package com.liu.config;

import com.liu.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author liuLiang
 * @create 2022/4/20 8:54
 * @email kekorand@gmail.com
 * @Description
 */
//@Configuration
//@ComponentScan(value = "com.liu")
public class MainConfig {
//    @Bean("lisa")
    public Person person(){
        return new Person("lisa",20);
    }
}
