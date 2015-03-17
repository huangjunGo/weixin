package org.easywechat.msg.req;

import org.easywechat.util.MessageBuilder;

public class BaseReq {

	String toUserName;// ������΢�ź�
	String fromUserName;// ���ͷ��ʺţ�һ��OpenID��
	long createTime;// ��Ϣ����ʱ��
	String msgType;// ��Ϣ����

	/**
	 * �õ�������΢�ź�
	 */
	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	/**
	 * �õ����ͷ��ʺţ�һ��OpenID��
	 */
	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	/**
	 * �õ���Ϣ����ʱ��
	 */
	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	/**
	 * �õ���Ϣ����
	 */
	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	/**
	 * ��ReqMsg����ת��XML��ʽ
	 */
	public String toXml() {
		// 159 = 106 + 28(ToUserName) + 15(FromUserName) + 10(CreateTime)
		MessageBuilder builder = new MessageBuilder(159);
		builder.addData("ToUserName", toUserName);
		builder.addData("FromUserName", fromUserName);
		builder.addTag("CreateTime", String.valueOf(createTime));
		return builder.toString();
	}

}
