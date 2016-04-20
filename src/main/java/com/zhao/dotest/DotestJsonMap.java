package com.zhao.dotest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/20.
 */
    public class DotestJsonMap {
        public static void main(String[] args){
            JSONObject obj=new JSONObject();
            obj.put("derek","23");
            obj.put("dad", "49");
            obj.put("mom", "45");
            System.out.println("通过构造器的方式创建的JSONObject对象："+obj);

            Map<String,String> map;
            map = new LinkedHashMap<String,String>();
            map.put("derek","23");
            map.put("dad", "49");
            map.put("mom", "45");
            System.out.println("通过fromObject方法将map对象转换为JSONObject对象："+JSONObject.fromObject(map));

            JSONArray arr=new JSONArray();
            arr.add(0,"derek");
            arr.add(1,"dad");
            arr.add(2,"mom");
            System.out.println("通过构造器的方式创建的JSONArray："+arr);

            ArrayList<String> list=new ArrayList<String>();
            list.add("derek");
            list.add("dad");
            list.add("mom");
            System.out.println("通过fromObject方法将Arraylist对象转换为JSONArray对象："+JSONArray.fromObject(list));

            System.out.println("将HashMap对象通过fromObject方法转换为JSONArray对象"+JSONArray.fromObject(map));

            String str="{\"derek\":23,\"dad\":49,\"mom\":45}";
            System.out.println("解析之后的JSON对象："+JSONObject.fromObject(str));

            //遍历输出
            Iterator<String> it=obj.keys();
            while(it.hasNext()){
                String key=it.next();
                System.out.println(key+":"+obj.get(key));
            }
        }

    }
