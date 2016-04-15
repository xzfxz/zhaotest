package com.zhao.dotest.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/4/7.
 */
public class RedisUtil {

    private static JedisPool pool;

    public static Jedis getJedis(){
        ResourceBundle bundle = ResourceBundle.getBundle("redis");

        JedisPoolConfig config = new JedisPoolConfig();
        String host = bundle.getString("redis.host");
        int port = Integer.parseInt(bundle.getString("redis.port"));
//        int timeout = Integer.parseInt(bundle.getString("redis.timeout"));
//        String password = bundle.getString("redis.password");
        config.setMaxTotal(Integer.valueOf(bundle.getString("redis.pool.maxActive")));
        config.setTestOnBorrow(Boolean.valueOf(bundle.getString("redis.pool.testOnBorrow")));
        pool = new JedisPool(config,host,port);
        Jedis jedis = pool.getResource();
        return jedis;
    }

    public static void release(Jedis jedis){
        jedis.close();
    }

}
