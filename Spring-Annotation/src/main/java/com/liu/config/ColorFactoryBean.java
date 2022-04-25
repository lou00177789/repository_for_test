package com.liu.config;

import com.liu.bean.Color;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author liuLiang
 * @create 2022/4/20 11:36
 * @email kekorand@gmail.com
 * @Description
 */
public class ColorFactoryBean implements FactoryBean<Color> {
    @Override
    public Color getObject() throws Exception {
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
