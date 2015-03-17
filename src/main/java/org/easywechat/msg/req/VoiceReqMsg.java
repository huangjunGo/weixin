package org.easywechat.msg.req;

import org.easywechat.util.MessageBuilder;

/**
 * ���յ���������Ϣ
 */
public final class VoiceReqMsg extends BaseReqMsg {

	private String mediaId;// ������Ϣý��id�����Ե��ö�ý���ļ����ؽӿ���ȡ����
	private String format;// ������ʽ����amr��speex��

	private String recognition;// ����ʶ������UTF8����

	/**
	 * ������Ϣý��id�����Ե��ö�ý���ļ����ؽӿ���ȡ����
	 */
	public String getMediaId() {
		return mediaId;
	}

	/**
	 * �õ�������ʽ����amr��speex��
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * �õ�����ʶ������UTF8����<br>
	 * ע�⣺���δ��ͨ����ʶ��ӿڣ��򷵻�null
	 */
	public String getRecognition() {
		return recognition;
	}

	public VoiceReqMsg(String mediaId, String format, String recognition) {
		super();
		this.mediaId = mediaId;
		this.format = format;
		this.recognition = recognition;
		setMsgType(ReqType.VOICE);
	}

	@Override
	public String toXml() {
		MessageBuilder mb = new MessageBuilder(super.toXml());
		mb.addData("MsgType", ReqType.VOICE);
		mb.addData("MediaId", mediaId);
		mb.addData("Format", format);
		mb.addTag("MsgId", msgId);
		mb.surroundWith("xml");
		return mb.toString();
	}

	@Override
	public String toString() {
		return "VoiceReqMsg [mediaId=" + mediaId + ", format=" + format
				+ ", recognition=" + recognition + ", msgId=" + msgId
				+ ", toUserName=" + toUserName + ", fromUserName="
				+ fromUserName + ", createTime=" + createTime + ", msgType="
				+ msgType + "]";
	}

}
