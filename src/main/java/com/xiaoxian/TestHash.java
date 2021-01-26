package com.xiaoxian;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 小贤
 * @PackageName:com.xiaoxian
 * @ClassName:TestHash
 * @Description:
 * @data 2021/1/23 17:36
 */
public class TestHash {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.204.133", 6380);
        jedis.select(0);

        jedis.hset("hashs", "name", "xiaoxian");
        jedis.hset("hashs", "age", "18");
        jedis.hset("hashs", "content", "帅哥");
        System.out.println(jedis.hget("hashs", "name"));

        Map<String, String> map = jedis.hgetAll("hashs");
        System.out.println(map);

        Boolean hexists = jedis.hexists("hashs", "age");
        System.out.println(hexists);

        Set<String> hashs = jedis.hkeys("hashs");
        System.out.println(hashs);

        List<String> hvals = jedis.hvals("hashs");
        System.out.println(hvals);

        jedis.hincrBy("hashs", "age", 10);
        System.out.println(jedis.hget("hashs", "age"));

        jedis.close();
    }
}
