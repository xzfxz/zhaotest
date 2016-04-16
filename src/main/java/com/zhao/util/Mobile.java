package com.zhao.util;

import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Mobile {

	/*public static boolean phoneCheck(Number phone, String verifcode){

        boolean flag = false;
        //Todo 从redis中取出以手机号取出对应的验证码
        String code = null;
        code = (String) session.getAttribute("code");
        if(code.equals( verifcode)){
            flag = true;
            session.setAttribute("code",null);
        }
        return flag;
    }*/
	//发送手机验证码
	public static String phoneSendcode(Number phone){
		boolean flag= false;
		String result = null;
		String random = YDMSM.getRandom();
		//Todo 将生成的手机验证码放进redis
		String message= null;
		try {
			message = YDMSM.sendMessage(new String[]{"1", String.valueOf(phone),random});
		} catch (Exception e) {
			e.printStackTrace();
		}
		if("Success".equals(message)){
			flag = true;
		}
		if(flag){
			result= random;
		}
		return result;
	}

	public static String request(String phone) {
		String httpUrl="http://apis.baidu.com/apistore/mobilephoneservice/mobilephone";
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		httpUrl = httpUrl + "?tel=" + phone;

		try {
			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("apikey","892a979baf9576b870b6f05fbe463975");
			connection.connect();
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			reader.close();
			result = sbf.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public static Map<String,String> getMobileTrackMap(String phoneCode){
		/*JSONObject 解析json数据*/
		Map<String,String> map = new HashMap<String,String>();
		String result = request(phoneCode);
		JSONObject js = JSONObject.fromObject(result);
		JSONObject retData = js.getJSONObject("retData");
		String province = retData.getString("province");
		map.put("province",province);
		return map;
	}

}
