package com.liu.dao;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Repository;

/**
 * @author liuLiang
 * @create 2022/4/20 9:12
 * @email kekorand@gmail.com
 * @Description
 */
@Repository
public class BookDao implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
