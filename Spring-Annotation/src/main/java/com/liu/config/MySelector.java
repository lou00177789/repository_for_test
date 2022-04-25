package com.liu.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author liuLiang
 * @create 2022/4/20 11:03
 * @email kekorand@gmail.com
 * @Description
 */
public class MySelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.liu.bean.Person"};
    }
}
