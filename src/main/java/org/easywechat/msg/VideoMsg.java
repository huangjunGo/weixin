package org.easywechat.msg;

import org.easywechat.util.MessageBuilder;

/**
 * ���ڻظ�����Ƶ��Ϣ
 */
public class VideoMsg extends BaseMsg {

	private String mediaId;
	private String title;
	private String description;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public VideoMsg(String mediaId) {
		this.mediaId = mediaId;
	}

	public VideoMsg(String mediaId, String title, String description) {
		this.mediaId = mediaId;
		this.title = title;
		this.description = description;
	}

	@Override
	public String toXml() {
		MessageBuilder mb = new MessageBuilder(super.toXml());
		mb.addData("MsgType", RespType.VIDEO);
		mb.append("<Video>\n");
		mb.addData("MediaId", mediaId);
		mb.addData("Title", title);
		mb.addData("Description", description);
		mb.append("</Video>\n");
		mb.surroundWith("xml");
		return mb.toString();
	}

	@Override
	public String toString() {
		return "VideoMsg [mediaId=" + mediaId + ", title=" + title
				+ ", description=" + description + "]";
	}

}
