package com.kgc.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * RedisAPI
 *
 * @author bdqn_shang
 * @date 2018-1-10
 */
@Component
public class RedisUtils {

    private Logger logger = LoggerFactory.getLogger(RedisUtils.class);

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * set key and value to redis
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key, String value) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置序列化Value的实例化对象
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        vo.set(key, value);
        return true;
    }

    /**
     * set key and value to redis
     *
     * @param key
     * @param seconds 有效期
     * @param value
     * @return
     */
    public boolean set(String key, long seconds, String value) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置序列化Value的实例化对象
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        vo.set(key, value,seconds, TimeUnit.SECONDS);
        return true;
    }

    /**
     * 判断某个key是否存在
     *
     * @param key
     * @return
     */
    public boolean exist(String key) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置序列化Value的实例化对象
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        Object value = vo.get(key);
        return EmptyUtils.isEmpty(value) ? false : true;
    }

    //setnx 加锁
    public boolean lock(final String key){
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                //序列化
                StringRedisSerializer serializer=new StringRedisSerializer();
                byte[] bytekey = serializer.serialize(key);
                byte[] bytevalue  = serializer.serialize("lock");
                Boolean nx = redisConnection.setNX(bytekey, bytevalue);
                if(nx) {
                    //有效期
                    redisConnection.expire(bytekey,60);//秒
                }
                return nx;
            }
        });
    }

    //解锁，删除

    public void unlock(String key){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.delete(key);
    }



    public Object get(String key) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置序列化Value的实例化对象
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        return vo.get(key);
    }

    public void delete(String key) {
        try {
            redisTemplate.delete(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    
    public boolean validate(String token) {
        return exist(token);
    }
}
