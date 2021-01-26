package com.xiaoxian;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @author 小贤
 * @PackageName:com.xiaoxian
 * @ClassName:TestSet
 * @Description:
 * @data 2021/1/23 16:56
 */
public class TestSet {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.204.133", 6380);
        jedis.select(0);

        jedis.sadd("name", "xiaoxian", "xiaojuan", "xiaodong");
        Set<String> names = jedis.smembers("name");
        names.forEach(name -> System.out.println(name));

        Long len = jedis.scard("name");
        System.out.println(len);

        String name = jedis.spop("name");
        System.out.println(name);

        jedis.srem("name", "xiaoxian");

        String name1 = jedis.srandmember("name");
        System.out.println(name1);



        jedis.close();
    }
}
