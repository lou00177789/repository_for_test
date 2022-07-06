package methodTypeTest;

import pojo.Man;
import pojo.Son;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

/**
 * @author liuLiang
 * @create 2022/4/25 8:59
 * @email kekorand@gmail.com
 * @Description
 */
public class MtTest {
    public static void main(String[] args) throws Throwable {
        MtTest mtTest = new MtTest();
        mtTest.test();
    }
    public void test() throws Throwable {
        MethodHandles.Lookup lookup = Son.getLookup();
        // 获取Son构造方法
        MethodType methodTypeConstruction = MethodType.methodType(void.class);
        MethodHandle constructor = lookup.findConstructor(Son.class, methodTypeConstruction);
        // 得到空son
        Son son = (Son)constructor.invoke();
        // 设置name

        // 方法句柄获取protected方法printAge
        MethodType mTShowMe = MethodType.methodType(void.class);
        MethodHandle testPrivate = lookup.findSpecial(Man.class, "testPrivate", mTShowMe, Man.class);
        MethodHandle testPublic = lookup.findVirtual(Son.class, "testPublic", mTShowMe);
        MethodHandle testProtected = lookup.findVirtual(Son.class, "testProtected", mTShowMe);
//        manPrintAge.invoke(son);

    }
}
