package com.xiaoxian;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @author 小贤
 * @PackageName:com.xiaoxian
 * @ClassName:TestString
 * @Description:
 * @data 2021/1/23 16:21
 */
public class TestString {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.204.133", 6380);
        jedis.select(0);

        jedis.set("name", "xiaoxian");
        System.out.println(jedis.get("name"));

        jedis.mset("age", "18", "content", "帅哥", "address", "江门新会");
        List<String> mget = jedis.mget("name", "age", "content", "address");
        mget.forEach(key -> System.out.println(key));

        String name = jedis.getSet("name", "xiaojuan");
        System.out.println(name);
        System.out.println(jedis.get("name"));

        Long len = jedis.strlen("name");
        System.out.println(len);

        jedis.append("name", " is a good girl");
        System.out.println(jedis.get("name"));

        String name1 = jedis.getrange("name", 0, 7);
        System.out.println(name1);

        String hobby = jedis.setex("hobby", 100, "play ball");
        System.out.println(jedis.ttl("hobby"));

        Long age = jedis.incr("age");
        System.out.println(age);

        jedis.close();
    }
}
