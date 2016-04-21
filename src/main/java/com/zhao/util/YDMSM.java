package com.zhao.util;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Random;

public class YDMSM {

	private final  static int min = 10;

	//返回六位随机数
	public  static String getRandom(){
		Random random = new Random();
		String result="";
		for(int i=0;i<6;i++){
			result+=random.nextInt(10);
		}
		return result;
	}

	//发送短信时候需要map中指定 phone 以及 content 内容
	// 返回的内容如果为Faild则失败，Success 则成功
	public static String sendMessage(String[] params) throws Exception {
		String result = null;
		result = parseXml(params);
		return result;
	}
	//0
	private static InputStream getMessageInputStream(String[] params) throws IOException {
		String id=params[0];
		String template="";
		if("0".equals(id)){
			template="尊敬的用户，您在易点征信平台有一笔"+params[2]+"，请及时登录平台进行处理 【易点征信】";
		}else{
			template = "您好，您的验证码为"+params[2]+"，请在"+min+"分钟内使用【易点征信】";
		}
		String phone = params[1];
		String account = "lcs00442";
		String passwd = "142581";
		String postData = "userid=&account="+account+"&password="+passwd+"&mobile="+phone
				+ "&sendTime=&content="+java.net.URLEncoder.encode(template,"utf-8");
		String postUrl = "http://sms.chanzor.com:8001/sms.aspx?action=send";

		try {
			if(params == null)
				return null;

			URL url = new URL(postUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setUseCaches(false);
			conn.setDoOutput(true);
			conn.setRequestProperty("Content-Length", "" + postData.length());

			OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
			out.write(postData);
			out.flush();
			out.close();


			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				System.out.println("connect failed!");
				return null;
			}
			//
			InputStream is = null;
			is = conn.getInputStream();
			return is;
		} catch (IOException e) {
			e.printStackTrace(System.out);
		}
		return null;
	}

	private static String parseXml(String[] params) throws DocumentException, IOException {
		String result = null;
		InputStream is = getMessageInputStream(params);
		if(is ==null){
			return "Faild";
		}
		SAXReader reader = new SAXReader();
		org.dom4j.Document dom = reader.read(is);
		Element root = dom.getRootElement();
		Element returnstatus = root.element("returnstatus");
		result = returnstatus.getText();
		return result;
	}
}
