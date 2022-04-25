package com.liu.config;

import com.liu.bean.Person;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.context.annotation.*;

/**
 * @author liuLiang
 * @create 2022/4/20 8:54
 * @email kekorand@gmail.com
 * @Description
 */
@Configuration
@ComponentScan(value = "com.liu")
@EnableAspectJAutoProxy
@Import({MySelector.class,MyImportBeanDefinitionRegistrar.class})
public class MainConfig1 {
    @Bean("lisa")
    public Person person(){
        AnnotationAwareAspectJAutoProxyCreator a = new AnnotationAwareAspectJAutoProxyCreator();

        return new Person("lisa",20);
    }

    @Bean
    public ColorFactoryBean color_f(){
        return new ColorFactoryBean();
    }
}
