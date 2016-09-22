package web.weixin.Model.Message;

import java.util.Map;

public class TextMsg extends ReplyMsg{
	protected String Content;

	public TextMsg(Map<String, Object> postData,String Content) {
		super(postData);
		this.Content = Content;
	}

}
