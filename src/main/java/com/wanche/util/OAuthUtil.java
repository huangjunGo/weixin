package com.wanche.util;

import com.wanche.pojo.SNSUserInfo;
import com.wanche.pojo.WeixinOauth2Token;

public class OAuthUtil {
	
	private static final String APPID="Test";
	
	private static final String APPSECRET="Test";
	
	public static SNSUserInfo getInfo(String code){
		SNSUserInfo snsUserInfo=null;
		if (!"authdeny".equals(code)) {
			// 获取网页授权access_token
			WeixinOauth2Token weixinOauth2Token = AdvancedUtil.getOauth2AccessToken(APPID, APPSECRET, code);
			if (weixinOauth2Token !=null) {
				// 网页授权接口访问凭证
				String accessToken = weixinOauth2Token.getAccessToken();
				// 用户标识
				String openId = weixinOauth2Token.getOpenId();
				// 获取用户信息
				snsUserInfo = AdvancedUtil.getSNSUserInfo(accessToken, openId);
			}
		}
		return snsUserInfo;
	}
}