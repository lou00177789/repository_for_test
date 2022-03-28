package singleton;

/**
 * @author liuLiang
 * @create 2022/2/23 13:43
 * @Description 单例自己想到的(饿汉)
 * @explain
 */
public class Singleton1 {

    private Singleton1(){

    }

    public static final Singleton1 INSTANCE = new Singleton1();

}
