package crawlerTest;

import org.apache.http.client.methods.HttpGet;

/**
 * @author liuLiang
 * @create 2022/3/16 16:48
 * @Description
 * @explain
 */
public class PicDownload {

    public static void download(String url,String path){
        HttpGet httpGet = new HttpGet(url);
    }
}
