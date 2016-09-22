package web.weixin.Model.Message;

import java.util.List;
import java.util.Map;

public class NewsMsg extends ReplyMsg{
	protected int ArticleCount;
	protected List<News> Articles;
	
	public NewsMsg(Map<String, Object> postData,List<News> newslist){
		super(postData);
		this.MsgType = "news";
		this.ArticleCount = newslist.size();
		this.Articles = newslist;
	}

}
