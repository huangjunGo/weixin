package org.easywechat.msg.req;

import org.easywechat.util.MessageBuilder;

/**
 * �ϱ�����λ���¼�
 */
public final class LocationEvent extends BaseEvent {

	private double latitude;// ����λ��γ��
	private double longitude;// ����λ�þ���
	private double precision;// ����λ�þ���

	/**
	 * �õ�����λ��γ��
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * �õ�����λ�þ���
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * �õ�����λ�þ���
	 */
	public double getPrecision() {
		return precision;
	}

	public LocationEvent(double latitude, double longitude, double precision) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.precision = precision;
	}

	@Override
	public String toXml() {
		MessageBuilder mb = new MessageBuilder(super.toXml());
		mb.addTag("Latitude", String.valueOf(latitude));
		mb.addTag("Longitude", String.valueOf(longitude));
		mb.addTag("Precision", String.valueOf(precision));
		mb.surroundWith("xml");
		return mb.toString();
	}

	@Override
	public String toString() {
		return "LocationEvent [latitude=" + latitude + ", longitude="
				+ longitude + ", precision=" + precision + ", toUserName="
				+ toUserName + ", fromUserName=" + fromUserName
				+ ", createTime=" + createTime + ", msgType=" + msgType + "]";
	}

}
