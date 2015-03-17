package com.wanche.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import net.sf.json.JSONObject;

import org.easywechat.msg.BaseMsg;
import org.easywechat.msg.TextMsg;

/**
 * 
 * @author hj
 * 2015-03-12
 * 图灵机器人智能回复
 */
public class TulingUtil {
	
	private static final String APIKEY="dd815d75bbf7186c030b2322f4f7b7d9";
	
	public static BaseMsg getBaseMsg(String info) throws Exception{
		String INFO = URLEncoder.encode(info, "utf-8");
		String getURL = "http://www.tuling123.com/openapi/api?key=" + APIKEY + "&info=" + INFO;
		URL getUrl = new URL(getURL);
		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
		connection.connect();
		// 取得输入流，并使用Reader读取
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
		StringBuffer sb = new StringBuffer();
		String line = "";
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		reader.close();
		// 断开连接
		JSONObject object = JSONObject.fromObject(sb.toString());
		String result = object.get("text").toString();
		if ("该功能不被图灵支持或者该功能已经停用".equals(result)) {
			result = "我真的什么都不知道，换个问题，放过我吧>_<";
		}
		if (object.get("url") != null) {
			result += object.get("url").toString();
		}
		return new TextMsg(result);
	}
	
	public static void main(String[] args) throws Exception {
		TulingUtil.getBaseMsg("林静是不是胖子");
	}
}
