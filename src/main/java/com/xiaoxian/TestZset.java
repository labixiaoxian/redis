package com.xiaoxian;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 小贤
 * @PackageName:com.xiaoxian
 * @ClassName:TestZset
 * @Description:
 * @data 2021/1/23 17:08
 */
public class TestZset {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.204.133", 6380);
        jedis.select(0);

        Map<String,Double> map = new HashMap<>();
        map.put("xiaoxian", 100.0);
        map.put("xiaojuan", 90.0);


        /*jedis.zadd("name", 90, "xiaojuan");
        jedis.zadd("name", 100, "xiaoxian");*/
        jedis.zadd("name", map);
        System.out.println(jedis.zcard("name"));

        Set<String> names = jedis.zrange("name", 0, -1);
        names.forEach(name -> System.out.println(name));

        Set<String> names2 = jedis.zrangeByScore("name", 0, 90);
        names2.forEach(name -> System.out.println(name));

        System.out.println(jedis.zrevrank("name", "xiaoxian"));
        System.out.println(jedis.zscore("name", "xiaoxian"));

        jedis.zrem("name", "xiaoxian");
        jedis.zincrby("name", 10,"xiaojuan");
        System.out.println(jedis.zscore("name", "xiaojuan"));



        jedis.close();
    }
}
