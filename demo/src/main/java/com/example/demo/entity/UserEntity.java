package com.example.demo.entity;

/**
 * @author liuLiang
 * @create 2022/4/8 20:59
 * @email kekorand@gmail.com
 * @Description
 */
public class UserEntity {
    String name;
    Integer age;

    @Override
    public String toString() {
        return "UserEntity{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public UserEntity() {
    }

    public UserEntity(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
