package com.zhao.dotest;

import com.zhao.entity.UserInfo;
import com.zhao.util.DayMonthYear;
import com.zhao.util.JavaBase64;
import com.zhao.util.RedisUtil;
import com.zhao.util.SerializeUtil;
import net.sf.json.JSONObject;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Created by Administrator on 2016/4/6.
 */
public class Dotest {
    @Test
    public void test10(){

            DayMonthYear st = new DayMonthYear();
            try {
                String liD = st.getDayDate("2015-08-01", "2015-8-31");
                String listM = st.getMonthDate("2015-08", "2015-10");
                String listY = st.getYearDate("2013", "2015");
                System.out.println(liD);
                System.out.println(listM);
                System.out.println(listY);
//			for(int i=0;i<listY.size();i++){
//				System.out.println(listY.get(i));
//			}
//			for(int i=0;i<listM.size();i++){
//				System.out.println(listM.get(i));
//			}
//			for (int i = 0; i < liD.size(); i++) {
//				System.out.println(liD.get(i));
//			}
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

    }
    @Test
    public void test09(){

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("identity","13682046273");
        map.put("salt","435253");
        map.put("password","414a0648ced58fc8444b8ed1223deac5");
        JSONObject obj = JSONObject.fromObject(map);
//        JSONObject obj = new JSONObject();
//        obj.element("app_name", "asdf");
//        obj.element("app_ip", "10.21.243.234");
//        obj.element("app_port", 8080);
//        obj.element("app_type", "001");
//        obj.element("app_area", "asd");
        System.out.println(obj);
    }
    @Test
    public void test08(){

        Charset charset = Charset.defaultCharset();
        ByteBuffer bb =  charset.encode("bb你好");
        byte[] array = bb.array();
        System.out.println(new String(array));
    }
    @Test
    public void test07(){
        SortedMap<String, Charset> map = Charset.availableCharsets();
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            Charset charset = map.get(next);
            System.out.println(next+"- - -"+charset);
        }
    }
    
    @Test
    public void test06(){
        Jedis jedis = RedisUtil.getJedis();
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
    }

    @Test
    public void test05(){
        String imageBinary = JavaBase64.getImageBinary();
        System.out.println(imageBinary);
        String url = JavaBase64.base64StringToImage(imageBinary);
        new File(url).delete();
    }

    @Test
    public void test04(){
        Jedis jedis = RedisUtil.getJedis();
        UserInfo userinfo = new UserInfo("tom",1,45.00);
        byte[] key = UUID.randomUUID().toString().getBytes();

        jedis.set(key, SerializeUtil.serialize(userinfo));
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
