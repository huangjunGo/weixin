package com.wanche.servlet;

import javax.servlet.annotation.WebServlet;

import org.easywechat.msg.BaseMsg;
import org.easywechat.msg.TextMsg;
import org.easywechat.msg.req.BaseEvent;
import org.easywechat.msg.req.LocationEvent;
import org.easywechat.msg.req.MenuEvent;
import org.easywechat.msg.req.TextReqMsg;
import org.easywechat.servlet.WeixinServletSupport;

import com.wanche.util.TulingUtil;
/**
 * 公众号验证处理请求Servlet
 * @author hj
 * @since 2015-03-10
 *
 */
@WebServlet("/wechat.htm")
public class DemoServlet extends WeixinServletSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String TOKEN="weixin";
	
	/**
	 * 验证token
	 */
	@Override
	protected String getToken() {
		return TOKEN;
	}
	
	/**
	 * 自动回复消息
	 * Todo 智能回复
	 */
	@Override
	protected BaseMsg handleTextMsg(TextReqMsg msg) {
		try {
			return TulingUtil.getBaseMsg(msg.getContent());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new TextMsg("感谢关注上海万车通！\r\n"
				+"登陆注册上海万车通网站，会员新年福利来袭！\r\n"
				+"全球限量499台、官方已售完、价值2600万的LaFerrari现已上线，且活动期间有零距离触碰体验，现在起赶快关注万车通官方微博微信，说不定那个幸运儿就是你！\r\n"
				+"电话：4006260613\r\n"
				+"QQ群：207484019\r\n"
				+"新浪微博：上海万车通\r\n"
				+"网址：http://www.wanchejinrong.com/index.html");
	}
	
	/**
	 * 点击菜单发送绑定链接，跳转到绑定页面
	 * 附带参数openId
	 */
	@Override
	protected BaseMsg handleMenuClickEvent(MenuEvent event) {
		String eventKey = event.getEventKey();
		if (eventKey.equals("V3_BIND")) {
			String openId = event.getFromUserName();
			return new TextMsg("点击")
			.addLink("这里绑定", "http://test.wanchejinrong.com/weixin/index_2.jsp?openId="+ openId)
			//.addLink("绑定", "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx8b857f0d92de14ce&redirect_uri=http://test.wanchejinrong.com/weixin/index.jsp&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect")
			.add("马上绑定！");
		}
		return null;
	}
	
	/**
	 * 
	 * 关注后自动回复-------------
	 * 感谢关注上海万车通！
		登陆注册上海万车通网站，会员新年福利来袭！
		全球限量499台、官方已售完、价值2600万的LaFerrari现已上线，且活动期间有零距离触碰体验，现在起赶快关注万车通官方微博微信，说不定那个幸运儿就是你！
		电话：4006260613
		QQ群：207484019
		新浪微博：上海万车通
		网址：http://www.wanchejinrong.com/index.html
		--------------------------
	 */
	@Override
	protected BaseMsg handleSubscribe(BaseEvent event) {
		return new TextMsg("感谢关注上海万车通！\r\n"
		+"登陆注册上海万车通网站，会员新年福利来袭！\r\n"
		+"全球限量499台、官方已售完、价值2600万的LaFerrari现已上线，且活动期间有零距离触碰体验，现在起赶快关注万车通官方微博微信，说不定那个幸运儿就是你！\r\n"
		+"电话：4006260613\r\n"
		+"QQ群：207484019\r\n"
		+"新浪微博：上海万车通\r\n"
		+"网址：http://www.wanchejinrong.com/index.html");
	}

//	@Override
//	protected BaseMsg handleLocationEvent(LocationEvent event) {
//		return new TextMsg("经度 ：" + event.getLatitude() + "维度 ： " + event.getLongitude() );
//	}
	
}
