package com.liu.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author liuLiang
 * @create 2022/4/20 10:30
 * @email kekorand@gmail.com
 * @Description
 */
public class Color implements InitializingBean {
    public Color() {
        System.out.println("------------------------");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }
}
