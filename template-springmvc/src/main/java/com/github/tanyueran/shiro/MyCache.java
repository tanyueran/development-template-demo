package com.github.tanyueran.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collection;
import java.util.Set;

public class MyCache<K, V> implements Cache<K, V> {

    private final static String PREFIX_CACHE_KEY = "template-spring-mvc-cache:";

    public String getKey(K key) {
        return PREFIX_CACHE_KEY + key;
    }


    @Autowired
    @Qualifier("redisTemplate2")
    private RedisTemplate redisTemplate;

    @Override
    public V get(K k) throws CacheException {
        Object o = redisTemplate.opsForValue().get(getKey(k));
        if (o == null) {
            return null;
        }
        return (V) o;
    }

    @Override
    public V put(K k, V v) throws CacheException {
//        redisTemplate.opsForValue().set();
        return v;
    }

    @Override
    public V remove(K k) throws CacheException {
        return null;
    }

    @Override
    public void clear() throws CacheException {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<K> keys() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }
}
