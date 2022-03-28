package socket;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author liuLiang
 * @create 2022/3/17 16:21
 * @Description
 * @explain
 */
public class ServiceTest {
    public static void main(String[] args) throws Exception {
        Class<ServiceTest> clazz = ServiceTest.class;
        Method printMe = clazz.getDeclaredMethod("printMe",String.class);
        printMe.setAccessible(true);
        printMe.invoke(new ServiceTest(),"hello");
    }

    public void printMe(String me){
        System.out.println(me);
    }
    private void accept() throws Exception{
        ServerSocket server = new ServerSocket(8080);
        Socket accept = server.accept();
        InputStream is = accept.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[5];
        int len;
        while((len = is.read(buffer)) != -1){
            baos.write(buffer,0,len);
        }
    }
}
