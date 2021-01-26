package com.xiaoxian;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
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
public class TestStringRedisTemplate {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testKey() {

    }

}
