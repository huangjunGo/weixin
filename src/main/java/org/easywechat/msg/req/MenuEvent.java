package org.easywechat.msg.req;

import org.easywechat.util.MessageBuilder;

/**
 * �Զ���˵��¼�
 */
public final class MenuEvent extends BaseEvent {

	private String eventKey;// �¼�KEYֵ�����Զ���˵��ӿ���KEYֵ��Ӧ

	/**
	 * �õ��¼�KEYֵ�����Զ���˵��ӿ���KEYֵ��Ӧ
	 */
	public String getEventKey() {
		return eventKey;
	}

	@Override
	/**
	 * �õ��¼����ͣ���CLICK��VIEW����
	 */
	public String getEvent() {
		return super.getEvent();
	}

	public MenuEvent(String eventKey) {
		super();
		this.eventKey = eventKey;
	}

	@Override
	public String toXml() {
		MessageBuilder mb = new MessageBuilder(super.toString());
		mb.addData("EventKey", eventKey);
		return mb.toString();
	}

	@Override
	public String toString() {
		return "MenuEvent [eventKey=" + eventKey + ", toUserName=" + toUserName
				+ ", fromUserName=" + fromUserName + ", createTime="
				+ createTime + ", msgType=" + msgType + "]";
	}

}
