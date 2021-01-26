package com.xiaoxian;

import redis.clients.jedis.BinaryClient;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @author 小贤
 * @PackageName:com.xiaoxian
 * @ClassName:TestList
 * @Description:
 * @data 2021/1/23 16:37
 */
public class TestList {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.204.133", 6380);
        jedis.select(0);

        jedis.lpush("name", "xiaoxian", "xiaojuan");
        jedis.rpush("name", "xiaodong", "xiaocheng");
        List<String> name = jedis.lrange("name", 0, -1);
        name.forEach(name1 -> System.out.println(name1));

        String popName = jedis.rpop("name");
        System.out.println(popName);
        List<String> name2 = jedis.lrange("name", 0, -1);
        name2.forEach(name1 -> System.out.println(name1));


        Long len = jedis.llen("name");
        System.out.println(len);

        jedis.lset("name", 2, "hahahahah");
        String indexName = jedis.lindex("name", 2);
        System.out.println(indexName);

        Long lrem = jedis.lrem("name", 1, "xiaoxian");

        jedis.linsert("name", BinaryClient.LIST_POSITION.AFTER, "xiaojuan", "xiaoxian");
        List<String> name3 = jedis.lrange("name", 0, -1);
        name3.forEach(name1 -> System.out.println(name1));

        jedis.close();
    }
}
