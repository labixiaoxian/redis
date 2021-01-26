package com.xiaoxian;

import redis.clients.jedis.Jedis;

/**
 * @author 小贤
 * @PackageName:com.xiaoxian
 * @ClassName:TestRedis
 * @Description:
 * @data 2021/1/21 21:23
 */
public class TestRedis {

    public static void main(String[] args) {
        //1.创建jedis对象
        Jedis jedis = new Jedis("192.168.204.133", 6380);

        //2.选择操作的库，默认0
        jedis.select(0);

        System.out.println("success");

        //3.释放资源
        jedis.close();
    }
}
