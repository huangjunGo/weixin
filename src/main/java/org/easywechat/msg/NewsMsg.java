package org.easywechat.msg;

import java.util.ArrayList;
import java.util.List;

import org.easywechat.util.MessageBuilder;

/**
 * ���ڻظ���ͼ����Ϣ<br>
 * <br>
 * 
 * ʾ�����룺
 * <p>
 * <blockquote>
 * 
 * <pre>
 * NewsMsg msg = new NewsMsg();
 * 
 * // ���ֻ�б����Article
 * msg.add(&quot;title1&quot;);
 * 
 * // ���ֻ�б�������ӵ�Article
 * msg.add(&quot;title2&quot;, &quot;url2&quot;);
 * 
 * // ��Ӿ��б��⡢���Ӻ�ͼƬ��Article
 * msg.add(&quot;title&quot;, &quot;picurl&quot;, &quot;url&quot;);
 * 
 * // ��Ӿ������в�����Article
 * msg.add(&quot;title&quot;, &quot;description&quot;, &quot;picUrl&quot;, &quot;url&quot;);
 * </pre>
 * 
 * </blockquote>
 * <p>
 * 
 */
public class NewsMsg extends BaseMsg {

	// ΢�Źٷ��涨ÿ��NewsMsg�����ʾ10��Article
	private static final int WX_MAX_SIZE = 10;

	// ����NewsMsg������Article���������ޡ�Ĭ�ϵ���΢�Ź涨���������ޣ���10��
	private int maxSize = WX_MAX_SIZE;

	List<Article> articles;

	public NewsMsg() {
		this.articles = new ArrayList<Article>(maxSize);
	}

	/**
	 * ����ͼ����Ϣʱָ��article���������
	 * 
	 * @param maxSize
	 *            article���������
	 */
	public NewsMsg(int maxSize) {
		setMaxSize(maxSize);
		this.articles = new ArrayList<Article>(maxSize);
	}

	/**
	 * ����ͼ����Ϣʱָ��article�б�<br>
	 * ע�⣺������ɺ�article�б�ı仯��Ȼ��Ӱ��ͼ����Ϣ
	 * 
	 * @param articles
	 *            a list of Article
	 */
	public NewsMsg(List<Article> articles) {
		setArticles(articles);
	}

	/**
	 * �õ�Article�������
	 */
	public int getMaxSize() {
		return maxSize;
	}

	/**
	 * ����NewsMsg�����Article�������
	 * 
	 * @param maxSize
	 *            NewsMsg�����Article�����������Χ��1~10
	 */
	public void setMaxSize(int maxSize) {
		if (maxSize > WX_MAX_SIZE || maxSize < 1) {
			maxSize = WX_MAX_SIZE;
		}
		this.maxSize = maxSize;
		if (articles != null && articles.size() > maxSize) {
			articles = articles.subList(0, maxSize);
		}
	}

	public List<Article> getArticles() {
		return articles;
	}

	/**
	 * ����ͼ����Ϣ��Articel�б�
	 * 
	 * @param articles
	 *            a list of Article
	 */
	public NewsMsg setArticles(List<Article> articles) {
		if (articles.size() > maxSize) {
			this.articles = articles.subList(0, maxSize);
		} else {
			this.articles = articles;
		}
		return this;
	}

	/**
	 * ΪNewsMsg���һ��ֻ���б����Article
	 * 
	 * @param title
	 *            Article�ı���
	 */
	public NewsMsg add(String title) {
		return add(title, null, null, null);
	}

	/**
	 * ΪNewsMsg���һ��ֻ���б�������ӵ�Article
	 * 
	 * @param title
	 *            Article�ı���
	 * @param url
	 *            Article������
	 */
	public NewsMsg add(String title, String url) {
		return add(title, null, null, url);
	}

	/**
	 * ΪNewsMsg���һ�����б��⡢���Ӻ�ͼƬ���ӵ�Article
	 * 
	 * @param title
	 *            Article�ı���
	 * @param picUrl
	 *            Article��ͼƬ����Դ��ַ
	 * @param url
	 *            Article������
	 */
	public NewsMsg add(String title, String picUrl, String url) {
		return add(new Article(title, null, picUrl, url));
	}

	/**
	 * ΪNewsMsg���һ��Article
	 * 
	 * @param title
	 *            Article�ı���
	 * @param description
	 *            Article������
	 * @param picUrl
	 *            Article��ͼƬ����Դ��ַ
	 * @param url
	 *            Article������
	 */
	public NewsMsg add(String title, String description, String picUrl,
			String url) {
		return add(new Article(title, description, picUrl, url));
	}

	/**
	 * Ϊͼ����Ϣ���һ��Article
	 * 
	 * @param article
	 */
	public NewsMsg add(Article article) {
		if (this.articles.size() < maxSize) {
			this.articles.add(article);
		} else {
			// ���Article�����������������
		}
		return this;
	}

	@Override
	/**
	 * {@inheritDoc}
	 */
	public String toXml() {
		MessageBuilder mb = new MessageBuilder(super.toXml());
		mb.addData("MsgType", RespType.NEWS);
		mb.addTag("ArticleCount", String.valueOf(articles.size()));
		mb.append("<Articles>\n");
		for (Article article : articles) {
			mb.append(article.toXml());
		}
		mb.append("</Articles>\n");
		mb.surroundWith("xml");
		return mb.toString();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("NewsMsg [articles=\n");
		for (int i = 0; i < articles.size(); i++) {
			sb.append("  Article ").append(i).append(": ")
					.append(articles.get(i)).append("\n");
		}
		sb.append("]");
		return sb.toString();
	}

}
