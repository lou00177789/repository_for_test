package com.liu;

import com.liu.bean.Person;
import com.liu.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liuLiang
 * @create 2022/4/20 8:49
 * @email kekorand@gmail.com
 * @Description
 */
public class MainTest {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
//        Person person = context.getBean("person", Person.class);
        Person person = context.getBean(Person.class);
        String[] type = context.getBeanNamesForType(Person.class);
        for (String t: type){
            System.out.println(t);
        }
        System.out.println(person);

        String[] names = context.getBeanDefinitionNames();
        for (String name: names){
            System.out.println(name);
        }
    }

}
