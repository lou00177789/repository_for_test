package dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * @author liuLiang
 * @create 2022/3/15 15:39
 * @Description
 * @explain
 */
public class JdkDynamicProxy {
    public static void main(String[] args) {
        DayWorkImpl dayWork = new DayWorkImpl();
        TimeHandler timeHandler = new TimeHandler(dayWork);
        IDayWork work = (IDayWork) Proxy.newProxyInstance(dayWork.getClass().getClassLoader(), dayWork.getClass().getInterfaces(), timeHandler);
        work.breakfast();
        work.lunch();
        work.dinner();
        System.out.println(work.getClass());
    }

}
