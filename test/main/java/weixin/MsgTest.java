package weixin;

import org.easywechat.msg.BaseMsg;
import org.easywechat.msg.TextMsg;

public class MsgTest {
	
	public static BaseMsg getBaseMsg(){
		return new TextMsg("你好");
	}
	
	public static void main(String[] args) {
		System.out.println(MsgTest.getBaseMsg().toXml());
	}
}
