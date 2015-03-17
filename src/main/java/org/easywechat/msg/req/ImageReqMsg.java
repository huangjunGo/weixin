package org.easywechat.msg.req;

import org.easywechat.util.MessageBuilder;

/**
 * ���յ���ͼƬ��Ϣ
 */
public final class ImageReqMsg extends BaseReqMsg {

	private String picUrl;// ͼƬ����
	private String mediaId;// ͼƬ��Ϣý��id�����Ե��ö�ý���ļ����ؽӿ���ȡ����

	/**
	 * �õ�ͼƬ����
	 */
	public String getPicUrl() {
		return picUrl;
	}

	/**
	 * �õ�ͼƬ��Ϣý��id�����Ե��ö�ý���ļ����ؽӿ���ȡ����
	 */
	public String getMediaId() {
		return mediaId;
	}

	public ImageReqMsg(String picUrl, String mediaId) {
		super();
		this.picUrl = picUrl;
		this.mediaId = mediaId;
		setMsgType(ReqType.IMAGE);
	}

	@Override
	public String toXml() {
		MessageBuilder mb = new MessageBuilder(super.toXml());
		mb.addData("MsgType", ReqType.IMAGE);
		mb.addData("PicUrl", picUrl);
		mb.addData("MediaId", mediaId);
		mb.addTag("MsgId", msgId);
		mb.surroundWith("xml");
		return mb.toString();
	}

	@Override
	public String toString() {
		return "ImageReqMsg [picUrl=" + picUrl + ", mediaId=" + mediaId
				+ ", toUserName=" + toUserName + ", fromUserName="
				+ fromUserName + ", createTime=" + createTime + ", msgType="
				+ msgType + ", msgId=" + msgId + "]";
	}

}
