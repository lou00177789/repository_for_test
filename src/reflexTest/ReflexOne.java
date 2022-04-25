package reflexTest;

import pojo.Man;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author liuLiang
 * @create 2022/4/15 9:14
 * @email kekorand@gmail.com
 * @Description 这个类用来捣鼓一下方法句柄
 * 理解：相当于一个指向方法的链接，简单的体现就是通过反射调用对象的方法：先找到方法，然后给类和参数让它执行
 * 要传类代表方法上其实没有存具体的类信息，对于通过反射获取、修改对应参数的值，其实是调用对应值的getter，setter
 *
 * 知乎上的解释：
 * 方法句柄是一个强类型的，能够被直接执行的引用。
 * 该引用可以指向常规的静态方法或者实例方法，也可以指向构造器或者字段。
 * 当指向字段时，方法句柄实则指向包含字段访问字节码的虚构方法，语义上等价于目标字段的 getter 或者 setter 方法。
 * 方法句柄的类型（MethodType）是由所指向方法的参数类型以及返回类型组成的。
 * 它是用来确认方法句柄是否适配的唯一关键。
 * 当使用方法句柄时，我们其实并不关心方法句柄所指向方法的类名或者方法名。
 *
 * 作者：hresh
 * 链接：https://zhuanlan.zhihu.com/p/477873226
 * 来源：知乎
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ReflexOne {
    public static void main(String[] args) throws Throwable {
        ReflexOne reflexOne = new ReflexOne();
        reflexOne.testTwo();
    }

    /**
     * 创建方法句柄的第一种方式 （MethodType）
     * 要用到的一个核心类是   MethodHandles.Lookup
     */
    public void testTwo() throws Throwable {
        Man man = new Man();
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        // 方式一
        Method showMe = Man.class.getDeclaredMethod("showMe", String.class);
        MethodHandle methodHandle = lookup.unreflect(showMe);
        // 方式二
        MethodType type = MethodType.methodType(int.class,String.class);
        MethodHandle methodHandle1 = lookup.findVirtual(Man.class, "showMe", type);
        int rand = (int) methodHandle1.invoke(man,"rand");
        int rand1 = (int) methodHandle1.invoke(man,"rand1");

        System.out.println(rand);
        System.out.println(rand1);
    }



    /**
     * 测试反射获取类的字段是否是通过getter方法
     * 事实证明不需要
     */
    public void testOne() throws Exception{
        Man man = new Man();
        Class<? extends Man> manClass = man.getClass();
        Field age = manClass.getDeclaredField("age");
        Method showMe = manClass.getDeclaredMethod("showMe", String.class);
        showMe.setAccessible(true);
        int o1 = (int)showMe.invoke(man, "testOne");
        age.setAccessible(true);
        age.set(man,4);
        int o = (int)age.get(man);
        System.out.println(o);
        o = 5;
        System.out.println(o);
    }
}
