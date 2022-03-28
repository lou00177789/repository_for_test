import singleton.Singleton3;

/**
 * @author liuLiang
 * @create 2022/2/23 13:54
 * @Description
 * @explain
 */
public class TestAll {
    public static void main(String[] args) {
        String info = Singleton3.INSTANCE.getInfo();
        System.out.println(info);
    }
}
