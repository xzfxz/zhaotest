package com.zhao.dotest;

import com.zhao.util.HttpRequestJson;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/21.
 */
public class TestPostJson {
    public static void main(String[] args) {
        String url="http://localhost:8081/index/login";
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("identity","13682046273");
        map.put("salt","435253");
        map.put("password","414a0648ced58fc8444b8ed1223deac5");

        String s = HttpRequestJson.sendPost(url, map);
        System.out.println(s);
    }
}
