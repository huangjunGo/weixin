package org.easywechat.msg;

import org.easywechat.util.MessageBuilder;

/**
 * ���ڻظ����ı���Ϣ<br>
 * <br>
 * 
 * ʾ�����룺
 * <p>
 * <blockquote>
 * 
 * <pre>
 * // ͨ�����췽��������Ϣ�ı���֮������������Ϣ���ݣ�
 * TextMsg msg = new TextMsg(&quot;hey:&quot;);
 * 
 * // addln�����������һ�����ݣ�����println��
 * // ��ͬ���ǣ�֧����ʽ���
 * msg.addln().addln(&quot;some text&quot;).addln(&quot;some other text&quot;);
 * 
 * // ��ӳ�����
 * msg.addLink(&quot;���������ҳ&quot;, &quot;http://www.example.com&quot;);
 * 
 * // �����Ϣ����
 * System.out.println(msg.getContent());
 * 
 * // ���������£�
 * // hey:
 * // some text
 * // some other text
 * // &lt;a href=&quot;http://www.example.com&quot;&gt;���������ҳ&lt;/a&gt;
 * 
 * </pre>
 * 
 * </blockquote>
 * <p>
 */
public final class TextMsg extends BaseMsg {

	// �ظ�����Ϣ����
	private StringBuilder contentBuilder;

	public String getContent() {
		return contentBuilder.toString();
	}

	public void setContent(String content) {
		contentBuilder = new StringBuilder(content);
	}

	public TextMsg() {
		contentBuilder = new StringBuilder();
	}

	public TextMsg(String content) {
		setContent(content);
	}

	/**
	 * �����Ϣ����
	 */
	public TextMsg add(String text) {
		contentBuilder.append(text);
		return this;
	}

	/**
	 * ��ӻ��з�
	 */
	public TextMsg addln() {
		return add("\n");
	}

	/**
	 * �������Ϣ����text������ӻ��з�
	 */
	public TextMsg addln(String text) {
		contentBuilder.append(text);
		return addln();
	}

	/**
	 * ����ı�Ϊtext,����Ϊurl�ĳ�����. ����
	 * <p>
	 * &lt;a href=&quot;url&quot;&gt;text&lt;/a&gt;
	 * </p>
	 */
	public TextMsg addLink(String text, String url) {
		contentBuilder.append("<a href=\"").append(url).append("\">")
				.append(text).append("</a>");
		return this;
	}

	@Override
	public String toXml() {
		MessageBuilder mb = new MessageBuilder(super.toXml());
		mb.addData("Content", contentBuilder.toString());
		mb.addData("MsgType", RespType.TEXT);
		mb.surroundWith("xml");
		return mb.toString();
	}

	@Override
	public String toString() {
		return "TextMsg [content=" + getContent() + "]";
	}

}
