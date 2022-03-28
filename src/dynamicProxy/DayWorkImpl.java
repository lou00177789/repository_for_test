package dynamicProxy;

/**
 * @author liuLiang
 * @create 2022/3/15 15:40
 * @Description
 * @explain
 */
public class DayWorkImpl implements IDayWork{
    @Override
    public void breakfast() {
        System.out.println("吃早饭");
    }

    @Override
    public void lunch() {
        System.out.println("吃午饭");
    }

    @Override
    public void dinner() {
        System.out.println("吃晚饭");
    }

}
