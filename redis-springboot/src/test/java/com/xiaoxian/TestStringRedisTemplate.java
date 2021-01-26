package com.xiaoxian;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author 小贤
 * @PackageName:com.xiaoxian
 * @ClassName:TestStringRedisTemplate
 * @Description:
 * @data 2021/1/24 14:47
 */
@SpringBootTest(classes = RedisSpringbootApplication.class)
@RunWith(SpringRunner.class)
public class TestStringRedisTemplate {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testKey() {
        stringRedisTemplate.delete("age");//删除key


        Boolean hasKey = stringRedisTemplate.hasKey("name");//判断key是否存在
        System.out.println("hasKey = " + hasKey);

        DataType type = stringRedisTemplate.type("name");//判断key的类型
        System.out.println("type = " + type);

        Set<String> keys = stringRedisTemplate.keys("*");//通配查询key
        keys.forEach(key-> System.out.println("key = " + key));

        Long expire = stringRedisTemplate.getExpire("name");//ttl 查询key的过时时间
        System.out.println("expire = " + expire);

        String randomKey = stringRedisTemplate.randomKey();//随机获取key
        System.out.println("randomKey = " + randomKey);

        stringRedisTemplate.renameIfAbsent("name", "name1");//重命名key

        stringRedisTemplate.move("name1", 1);

    }

    @Test
    public void testString() {
        stringRedisTemplate.opsForValue().set("name", "xiaoxian");//设置一个key value

        String name = stringRedisTemplate.opsForValue().get("name");//获取key的值
        System.out.println("name = " + name);

        stringRedisTemplate.opsForValue().set("code", "12456", 100, TimeUnit.SECONDS);//设置一个带超时时间的key value

        stringRedisTemplate.opsForValue().append("name", " is a good man!");//在key对应的value追加值

    }

    @Test
    public void testList() {
        stringRedisTemplate.opsForList().leftPush("names", "xiaoxian");//往list中添加元素
        stringRedisTemplate.opsForList().leftPushAll("names", "xiaojuan", "xiaodong");//添加元素
        List<String> names = new ArrayList<>();
        names.add("hahahahh");
        names.add("xixiixxi");
        stringRedisTemplate.opsForList().leftPushAll("names", names);//设置值

        List<String> range = stringRedisTemplate.opsForList().range("names", 0, -1);//遍历list
        range.forEach(value-> System.out.println("value = " + value));

        String leftPop = stringRedisTemplate.opsForList().leftPop("names");//返回并删除左边的第一个元素
        System.out.println("leftPop = " + leftPop);

        stringRedisTemplate.opsForList().trim("names", 1, 3);//截取指定区间的元素

    }


    @Test
    public void testSet() {
        stringRedisTemplate.opsForSet().add("sets", "xiaoxain", "xiaojuan");//创建set 并将多个元素放入集合

        Set<String> sets = stringRedisTemplate.opsForSet().members("sets");//查看set中成员 遍历
        sets.forEach(set-> System.out.println("set = " + set));

        Long size = stringRedisTemplate.opsForSet().size("sets");//set集合中的个数
        System.out.println("size = " + size);

        String pop = stringRedisTemplate.opsForSet().pop("sets");//随机返回一个元素并删除
        System.out.println("pop = " + pop);

        String randomMember = stringRedisTemplate.opsForSet().randomMember("sets");//随机返回一个元素
        System.out.println("randomMember = " + randomMember);

    }


    @Test
    public void testZset() {

        stringRedisTemplate.opsForZSet().add("zsets", "xiaoxian", 100);//设置值
        Set<ZSetOperations.TypedTuple<String>> zset = stringRedisTemplate.opsForZSet().rangeByScoreWithScores("zsets", 0, 100);
        zset.forEach(value -> System.out.println(value.getScore() + "-----" + value.getValue()));//该分数遍历

        Long rank = stringRedisTemplate.opsForZSet().rank("zsets", "xiaoxian");//返回该元素的排名
        System.out.println("rank = " + rank);

    }

    @Test
    public void testHash() {
        stringRedisTemplate.opsForHash().put("maps", "name", "xiaoxian");//创建一个hash类型 并放入key value

        Map<String, String> map = new HashMap<>();
        map.put("age", "12");
        map.put("bir", "2021/1/26");
        stringRedisTemplate.opsForHash().putAll("maps", map);//放入多个key value

        String name = (String) stringRedisTemplate.opsForHash().get("maps", "name");//获取hash中某个key的值
        System.out.println("name = " + name);

        List<Object> multiGet = stringRedisTemplate.opsForHash().multiGet("maps", Arrays.asList("name", "age"));//获取多个key的值
        multiGet.forEach(values -> System.out.println("values = " + values));

        Set<Object> maps = stringRedisTemplate.opsForHash().keys("maps");//获取hash中所有的key
        System.out.println(maps);

        List<Object> values = stringRedisTemplate.opsForHash().values("maps");//获取hahs中所有values的值
        System.out.println(values);
    }

}
