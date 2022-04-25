import com.liu.config.MainConfig;
import com.liu.config.MainConfig1;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liuLiang
 * @create 2022/4/20 9:19
 * @email kekorand@gmail.com
 * @Description
 */
public class MainTest {
    public static ApplicationContext context = null;
    @Before
    public void init(){
//        ApplicationContext annotationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        ApplicationContext annotationContext1 = new AnnotationConfigApplicationContext(MainConfig1.class);
        context = annotationContext1;
    }
    @Test
    public void test1(){
        String[] names = context.getBeanDefinitionNames();
        for (String name:names){
            System.out.println(name);
        }
        Object color_f = context.getBean("color_f");
        Class<?> aClass = color_f.getClass();
        System.out.println(aClass.getName());
    }
}
