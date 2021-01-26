package com.xiaoxian;

import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;

/**
 * @author 小贤
 * @PackageName:com.xiaoxian
 * @ClassName:TestKey
 * @Description:
 * @data 2021/1/23 16:04
 */
public class TestKey {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.204.133", 6380);
        jedis.select(0);

        jedis.set("name", "xiaoxian");
        System.out.println(jedis.get("name"));

        jedis.set("age", "19");
        System.out.println(jedis.exists("age"));

        Long age = jedis.expire("age", 100);
        System.out.println(age);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Long age1 = jedis.ttl("age");
        System.out.println(age1);

        String s = jedis.randomKey();
        System.out.println(s);

        String name = jedis.type("name");
        System.out.println(name);

        Long age2 = jedis.decr("age");
        System.out.println(age2);

        Long name1 = jedis.del("name");
        System.out.println(name1);

        jedis.close();
    }
}
