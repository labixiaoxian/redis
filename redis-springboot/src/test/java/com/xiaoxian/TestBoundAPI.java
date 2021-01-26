package com.xiaoxian;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 小贤
 * @PackageName:com.xiaoxian
 * @ClassName:TestStringRedisTemplate
 * @Description:
 * @data 2021/1/24 14:47
 */
@SpringBootTest(classes = RedisSpringbootApplication.class)
@RunWith(SpringRunner.class)
public class TestBoundAPI {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testBoundAPI() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());

        BoundValueOperations<String, String> boundValueOperations = stringRedisTemplate.boundValueOps("name");
        boundValueOperations.set("xiaoxian");
        boundValueOperations.append(" is a good man");
        String s = boundValueOperations.get();

//        redisTemplate.boundValueOps("name");
//        redisTemplate.boundListOps("list");
//        stringRedisTemplate.boundListOps("list");
//        redisTemplate.boundSetOps("set");
//        stringRedisTemplate.boundSetOps("set");
//        redisTemplate.boundZSetOps("zset");
//        stringRedisTemplate.boundZSetOps("zset");
//        redisTemplate.boundHashOps("hash");
//        stringRedisTemplate.boundHashOps("hash");
    }

}
