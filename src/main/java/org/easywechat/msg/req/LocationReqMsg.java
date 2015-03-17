package org.easywechat.msg.req;

import org.easywechat.util.MessageBuilder;

/**
 * ���յ��ĵ���λ����Ϣ
 */
public final class LocationReqMsg extends BaseReqMsg {

	private double locationX;// ����λ��γ��
	private double locationY;// ����λ�þ���
	private int scale;// ��ͼ���Ŵ�С
	private String label;// ����λ����Ϣ

	/**
	 * �õ�����λ��γ��
	 */
	public double getLocationX() {
		return locationX;
	}

	/**
	 * �õ�����λ�þ���
	 */
	public double getLocationY() {
		return locationY;
	}

	/**
	 * �õ���ͼ���Ŵ�С
	 */
	public int getScale() {
		return scale;
	}

	/**
	 * �õ�����λ����Ϣ
	 */
	public String getLabel() {
		return label;
	}

	public LocationReqMsg(double locationX, double locationY, int scale,
			String label) {
		super();
		this.locationX = locationX;
		this.locationY = locationY;
		this.scale = scale;
		this.label = label;
		setMsgType(ReqType.LOCATION);
	}

	@Override
	public String toXml() {
		MessageBuilder mb = new MessageBuilder(super.toXml());
		mb.addData("MsgType", ReqType.LOCATION);
		mb.addTag("Location_X", String.valueOf(locationY));
		mb.addTag("Location_Y", String.valueOf(locationX));
		mb.addTag("Scale", String.valueOf(scale));
		mb.addData("Label", label);
		mb.addTag("MsgId", msgId);
		mb.surroundWith("xml");
		return mb.toString();
	}

	@Override
	public String toString() {
		return "LocationReqMsg [locationX=" + locationX + ", locationY="
				+ locationY + ", scale=" + scale + ", label=" + label
				+ ", toUserName=" + toUserName + ", fromUserName="
				+ fromUserName + ", createTime=" + createTime + ", msgType="
				+ msgType + ", msgId=" + msgId + "]";
	}

}
