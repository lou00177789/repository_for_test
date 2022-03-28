package redis;
import redis.clients.jedis.Jedis;

/**
 * @author liuLiang
 * @create 2022/2/23 11:07
 * @Description
 * @explain
 */
public class redisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.41.131");
        System.out.println("测试连接：" + jedis.ping());
        String a = jedis.get("a");
        jedis.lpush("lpushkey1","123");
        System.out.println(a);
        jedis.close();

    }
}
