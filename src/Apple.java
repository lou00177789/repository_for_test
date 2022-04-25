import java.io.Serializable;
import java.lang.ref.SoftReference;

/**
 * @author liuLiang
 * @create 2022/4/5 10:51
 * @email kekorand@gmail.com
 * @Description
 */
public class Apple {
    public static int count = 0;

    public void plus(int a){
        Apple apple = new Apple();
        synchronized (apple){
            count = count + a;
        }
    }
}
