package web.weixin.Model.Message;

import java.util.Date;
import java.util.Map;

public class ReplyMsg {
	protected String ToUserName;
	protected String FromUserName;
	protected long CreateTime;
	public String MsgType;

	public ReplyMsg(Map<String, Object> postData){
		this.ToUserName = postData.get("FromUserName").toString();
		this.FromUserName = postData.get("ToUserName").toString();
		this.CreateTime = new Date().getTime();
		this.MsgType = "text";
	}
}
