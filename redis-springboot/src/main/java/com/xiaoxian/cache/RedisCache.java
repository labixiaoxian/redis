package com.xiaoxian.cache;

import com.xiaoxian.util.ApplicationUtil;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.DigestUtils;

/**
 * @author 小贤
 * @PackageName:cache
 * @ClassName:RedisCache
 * @Description:
 * @date 2021/1/26 22:30
 */
public class RedisCache implements Cache {

    private final String id;

    public RedisCache(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        getRedisTemplate().opsForHash().put(id.toString(),getMd5Key(key.toString()),value);
    }

    @Override
    public Object getObject(Object key) {
        return getRedisTemplate().opsForHash().get(id.toString(),getMd5Key(key.toString()));
    }

    @Override
    public Object removeObject(Object o) {
        return null;
    }

    @Override
    public void clear() {
        getRedisTemplate().delete(id.toString());
    }

    @Override
    public int getSize() {
        return getRedisTemplate().opsForHash().size(id.toString()).intValue();
    }


    /* * @Author 小贤
     * @Description //注入redisTemplate对象
     * @Date 14:25 2021/1/27
     * @Param []
     * @return org.springframework.data.redis.core.RedisTemplate
     **/
    private RedisTemplate getRedisTemplate() {
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationUtil.getBean("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }

    private String getMd5Key(String key) {
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }
}
