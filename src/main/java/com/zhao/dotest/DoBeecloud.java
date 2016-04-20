package com.zhao.dotest;

import com.zhao.util.HttpRequestJson;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/20.
 */
public class DoBeecloud {

    public static void main(String[] args) {
        String url ="https://apidynamic.beecloud.cn/2/rest/bill";
        Map<String,String> map = new HashMap<String,String>();

        HttpRequestJson.sendPost(url,map);

    }
}
