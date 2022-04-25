package reflexTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author liuLiang
 * @create 2022/4/15 11:08
 * @email kekorand@gmail.com
 * @Description 通过代理 + 自定义注解实现在指定注解上的方法前打印 “注手”
 *
 */
public class ReflexTwo {
    public static void main(String[] args) {


    }

    /**
     * 测试纯手动的方式实现
     */
    public void testPoxy(){

    }

    /**
     * 测试自带的方式实现
     */
    public void testPoxyHandler(){
        Computer computer = new Computer();
        computer.setModel(9700);
        computer.setName("Dell");
        MyPoxyHandler handler = new MyPoxyHandler(computer);
        ShowMe showMe = (ShowMe)Proxy.newProxyInstance(Computer.class.getClassLoader(), Computer.class.getInterfaces(), handler);
        showMe.show();
    }
}

/**
 * 代理类
 */
class MyPoxy {
    public <T> T getPoxy(T target){
        // 获取到所有方法,筛选出带有指定注解的方法
        Method[] methods = target.getClass().getDeclaredMethods();
        Stream<Method> methodStream = Arrays.stream(methods).filter(me -> me.getAnnotation(MyAnnotation.class) != null);

        MyPoxy myPoxy = new MyPoxy(target);
        return target;
    }

    Object target;

    public MyPoxy (Object obj){
        this.target = obj;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
        if (annotation != null){
            String value = annotation.value();
            System.out.println(value + "MyAnnotation ");
        }
        return method.invoke(target,args);
    }
}

/**
 * 代理类处理程序
 */
class MyPoxyHandler implements InvocationHandler {

    Object target;

    public MyPoxyHandler (Object obj){
        this.target = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
        if (annotation != null){
            String value = annotation.value();
            System.out.println(value + "MyAnnotation ");
        }
        return method.invoke(target,args);
    }
}

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{
    String value();
}

/**
 * 方法接口
 */
interface ShowMe{
    @MyAnnotation("computer show：")
    void show();
}

/**
 * 被代理类
 */
class Computer implements ShowMe{

    private int model;
    public String name;

    @Override
    public void show(){
        System.out.println(name + model);
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}