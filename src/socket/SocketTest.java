package socket;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author liuLiang
 * @create 2022/3/17 16:01
 * @Description
 * @explain
 */
public class SocketTest {
    public static void main(String[] args) {

    }

    private void sentMessage() throws Exception{
        Socket socket = new Socket("127.0.0.1", 8080);
        OutputStream os = socket.getOutputStream();
        boolean autoFlush = true;
        PrintWriter out = new PrintWriter(socket.getOutputStream(), autoFlush);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        out.println("GET /index.jsp HTTP/1.1");
        out.println("Host: localhost:8080");
        out.println("Connection: Close");
        out.println();

        boolean loop = true;
        StringBuffer sb = new StringBuffer(8096);
        while (loop){
            if (in.ready()){
                int i = 0;
                while (i!=-1){
                    i = in.read();
                    sb.append((char)i);
                }
                loop = false;
            }
            Thread.sleep(50);

            System.out.println(sb.toString());
            socket.close();

        }
    }
}
