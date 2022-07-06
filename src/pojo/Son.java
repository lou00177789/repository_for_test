package pojo;

import java.lang.invoke.MethodHandles;

/**
 * @author liuLiang
 * @create 2022/4/25 9:06
 * @email kekorand@gmail.com
 * @Description
 */
public class Son extends Man{
    public static MethodHandles.Lookup getLookup(){
        return MethodHandles.lookup();
    }
    private void testPrivate(){

    }
    protected void testProtected(){

    }
    public void testPublic(){

    }

    @Override
    protected void printAge() {
        System.out.println("this is son' printAge");
    }
}
