package com.zhao.dotest.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Created by Administrator on 2016/4/6.
 */
public class Dotest {
    @Test
    public void test06(){
        Jedis jedis = RedisUtil.getJedis();
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
    }

    @Test
    public void test05(){
        String imageBinary = JavaBase64Test.getImageBinary();
        System.out.println(imageBinary);
        String url = JavaBase64Test.base64StringToImage(imageBinary);
        new File(url).delete();
    }

    @Test
    public void test04(){
        Jedis jedis = RedisUtil.getJedis();
        UserInfo userinfo = new UserInfo("tom",1,45.00);
        byte[] key = UUID.randomUUID().toString().getBytes();

        jedis.set(key,SerializeUtil.serialize(userinfo));
        String china = jedis.get("name");
        System.out.println(china);
        RedisUtil.release(jedis);
        byte[] s = jedis.get(key);
        System.out.println(s);
        UserInfo userinfo2 = (UserInfo)SerializeUtil.deserialize(s);
        System.out.println(userinfo2.getScore());
    }
    @Test
    public void test03() {
        Jedis jedis = RedisUtil.getJedis();
        jedis.set("china", "xian");
        jedis.lpush("userlist", "z3");
        jedis.lpush("userlist", "z4");
        jedis.lpush("userlist", "z4");
        List<String> userlist = jedis.lrange("userlist", 0, -1);
        System.out.println(userlist);
    }
    @Test
    public void test033() {
        Jedis jedis = RedisUtil.getJedis();

        jedis.sadd("names","tom","niki");
        Set<String> names = jedis.smembers("names");

        System.out.println(names);
    }
    @Test
    public void test0323() {
        Jedis jedis = RedisUtil.getJedis();
        jedis.zadd("persons",11.0,"z2222");
        jedis.zadd("persons",11.1,"z2222");
        jedis.zadd("persons",12.0,"z222");
        jedis.zadd("persons",9,"z11");
        jedis.zadd("persons",10.01,"z12");
        Set<String> persons = jedis.zrange("persons", 0, -1);

        System.out.println(persons);
    }

    @Test
    public void test02(){
        Jedis jedis = new Jedis("192.168.1.112");
        jedis.set("name","z3");
        String name = jedis.get("name");
        System.out.print(name);

    }

    @Test
    public void test01() throws IOException {
        File file = new File("D:\\a.txt");
        FileInputStream fis = new FileInputStream(file);
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len =fis.read(bytes))!=-1){
            String s = new String(bytes,0,len);
            System.out.print(s);
        }
    }
}
