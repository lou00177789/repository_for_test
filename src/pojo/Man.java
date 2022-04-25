package pojo;

import java.util.Objects;

/**
 * @author liuLiang
 * @create 2022/4/14 11:49
 * @email kekorand@gmail.com
 * @Description 判断对象是否相同：
 * 1、直接hash，不同就不是，相同下一步（因为相同可能会有hash碰撞）
 * 2、然后equals
 */
public class Man extends Object{
    int age = 8;
    String name;

    public int showMe(String str){
        System.out.println(name + str);
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // 如果地址一样就肯定是一个对象
        if (o == null || getClass() != o.getClass()) return false; // 都不是一个类的肯定不同，同时排除掉类型转换异常
        Man man = (Man) o;
        return age == man.age && Objects.equals(name, man.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}
