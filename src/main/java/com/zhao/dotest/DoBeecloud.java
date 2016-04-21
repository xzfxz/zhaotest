package com.zhao.dotest;

import com.zhao.util.HttpRequestJson;
import com.zhao.util.MD5andKL;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2016/4/20.
 */
public class DoBeecloud {

    public static void main(String[] args) {
        //请求的url
        String url ="https://apidynamic.beecloud.cn/2/rest/bill";
        Map<String,Object> map = new HashMap<String,Object>();
        //appid
        String appid="3cd10cc0-4498-46a5-b346-260e3be65cb5";
//        String appid="0950c062-5e41-44e3-8f52-f89d8cf2b6eb";
        map.put("app_id",appid);
        //app src
        String app_src="5ad656d0-6f57-4e90-841c-3369dbb7d60c";
        Long timestamp=System.currentTimeMillis();
        map.put("timestamp",timestamp);
        String s1 = MD5andKL.MD5(appid + timestamp + app_src);
        System.out.println(s1);
        System.out.println(s1.length());
//签名
        map.put("app_sign", s1);
//        map.put("app_sign", "b927899dda6f9a04afc57f21ddf69d69");
        //支付的场景
        map.put("channel","UN_WEB");
        //支付金额
        map.put("total_fee",1);
        //8到32位数字和/或字母组合，请自行确保在商户系统中唯一，同一订单号不可重复提交，否则会造成订单重复
        map.put("bill_no", UUID.randomUUID().toString().replace("-",""));
//标题
        map.put("title","白开水");
//附加项
        Map<String,String> map2 = new HashMap<String, String>();
        map2.put("os","ios");
        map2.put("app_version","11.0");
        map.put("optional",map2);
//        支付渠道处理完请求后,当前页面自动跳转到商户网站里指定页面的http路径，中间请勿有#,?等字符
        map.put("return_url","http://beecloud.cn/returnUrl.jsp");
//        必须为非零正整数，单位为秒，建议最短失效时间间隔必须大于360秒
        map.put("bill_timeout",360);
        String s = HttpRequestJson.sendPost(url, map);
        System.out.print(s);

    }
}
