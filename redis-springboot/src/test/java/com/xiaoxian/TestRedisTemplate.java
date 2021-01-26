package com.xiaoxian;

import com.xiaoxian.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;

/**
 * @author 小贤
 * @PackageName:com.xiaoxian
 * @ClassName:TestStringRedisTemplate
 * @Description:
 * @data 2021/1/24 14:47
 */
@SpringBootTest(classes = RedisSpringbootApplication.class)
@RunWith(SpringRunner.class)
public class TestRedisTemplate {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testRedisTemplate() {

        //修改key序列化方案 string类型序列
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        //修改hash key序列方案 string类型序列
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());

        User user = new User();
        user.setId(UUID.randomUUID().toString()).setName("xiaoxian").setAge(18).setBir(new Date());

        redisTemplate.opsForValue().set("user", user);

        redisTemplate.opsForList().leftPush("list", user);

        redisTemplate.opsForSet().add("set", user);

        redisTemplate.opsForZSet().add("zset", user,100);

        redisTemplate.opsForHash().put("map", "name", user);

    }

}
