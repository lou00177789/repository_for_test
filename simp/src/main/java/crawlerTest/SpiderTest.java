package crawlerTest;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

/**
 * @author liuLiang
 * @create 2022/3/16 15:57
 * @Description
 * https://blog.csdn.net/qq_46239972/article/details/110480612
 * https://www.jianshu.com/p/383e4e9e123f
 * @explain
 */
public class SpiderTest {
    public static void main(String[] args) throws IOException {

//        String url = "https://www.vmgirls.com/18261.html";
        String url = "https://t.cdn.ink/image/2022/03/2022031417252249.jpeg";

        WebClient browser = new WebClient();
        browser.getOptions().setCssEnabled(false);
        browser.getOptions().setJavaScriptEnabled(true);
        browser.getOptions().setThrowExceptionOnScriptError(false);
        //获取页面
        HtmlPage htmlPage = browser.getPage(url);

        //设置等待js的加载时间
        browser.waitForBackgroundJavaScript(5000);//加载5s
        //使用xml的方式解析获取到jsoup的document对象
        Document document = Jsoup.parse(htmlPage.asXml());

        Element body = document.body();
        System.out.println(body);


    }
}
