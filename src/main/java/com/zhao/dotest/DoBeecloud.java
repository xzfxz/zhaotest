package com.zhao.dotest;

import com.zhao.util.HttpRequestJson;
import com.zhao.util.MD5andKL;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/20.
 */
public class DoBeecloud {

    public static void main(String[] args) {
        String url ="https://apidynamic.beecloud.cn/2/rest/bill";
        Map<String,Object> map = new HashMap<String,Object>();
        String appid="3cd10cc0-4498-46a5-b346-260e3be65cb5";
        map.put("app_id",appid);
        String app_src="5ad656d0-6f57-4e90-841c-3369dbb7d60c";
        Long timestamp=System.currentTimeMillis();
        map.put("timestamp",timestamp);
        map.put("app_sign", MD5andKL.MD5(appid+timestamp+app_src));
        map.put("channel","UN_WEB");
        map.put("total_fee",1);
        map.put("bill_no","201506101035040000001");
        map.put("title","白开水");
        Map<String,String> map2 = new HashMap<String, String>();
        map2.put("os","ios");
        map2.put("app_version","11.0");
//        map.put("optional",map2);
        map.put("return_url","http://beecloud.cn/returnUrl.jsp");
        map.put("bill_timeout",360);
        String s = HttpRequestJson.sendPost(url, map);
        System.out.print(s);

    }
}
