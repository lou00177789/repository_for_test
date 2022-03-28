package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author liuLiang
 * @create 2022/3/15 15:41
 * @Description
 * @explain
 */
public class TimeHandler implements InvocationHandler {
    private Object target;
    public TimeHandler(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("吃饭之前要洗手");
        //调用真正的方法
        Object retVal = method.invoke(target, args);
        System.out.println("吃饭之后要洗碗");
        return retVal;
    }

}
