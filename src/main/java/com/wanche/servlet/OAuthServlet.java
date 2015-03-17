package com.wanche.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wanche.pojo.SNSUserInfo;
import com.wanche.pojo.WeixinOauth2Token;
import com.wanche.util.AdvancedUtil;

/**
 * 授权后的回调请求处理
 * 
 */
@WebServlet("/oAuth.htm")
public class OAuthServlet extends HttpServlet{
	private static final long serialVersionUID = -1847238807216447030L;
	
	private static final String APPID="Test";
	
	private static final String APPSECRET="Test";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 用户同意授权后，能获取到code	`
		String code = request.getParameter("code");
		System.out.println(code);
		// 用户同意授权
		if ( code !=null || !"authdeny".equals(code)) {
			// 获取网页授权access_token
			WeixinOauth2Token weixinOauth2Token = AdvancedUtil.getOauth2AccessToken(APPID, APPSECRET, code);
			
			if (weixinOauth2Token != null) {
				String accessToken = weixinOauth2Token.getAccessToken();
				// 用户标识
				String openId = weixinOauth2Token.getOpenId();
				// 获取用户信息
				SNSUserInfo snsUserInfo = AdvancedUtil.getSNSUserInfo(accessToken, openId);
				//设置要传递的参数
				request.setAttribute("snsUserInfo", snsUserInfo);
			}
			// 网页授权接口访问凭证
		}
		// 跳转到index.jsp
		request.getRequestDispatcher("index_3.jsp").forward(request, response);
	}
}
