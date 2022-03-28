package singleton;

import java.io.IOException;
import java.util.Properties;

/**
 * @author liuLiang
 * @create 2022/2/23 13:55
 * @Description
 * @explain
 */
public class Singleton3 {
    public static final Singleton3 INSTANCE;
    private String info;
    static {
        Properties p = new Properties();
        try {
            p.load(Singleton3.class.getClassLoader().getResourceAsStream("singleton.properties"));
        } catch (IOException e) {
            throw new RuntimeException("文件加载失败！");
        }
        INSTANCE = new Singleton3(p.getProperty("info"));
    }
    private Singleton3(String info){
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Singleton3{" +
                "info='" + info + '\'' +
                '}';
    }
}
