package web.weixin.Model.Message;

import java.util.Map;

public class VoiceMsg extends ReplyMsg {

	protected Media Voice;

	public VoiceMsg(Map<String, Object> postData,String MediaId) {
		super(postData);
		this.MsgType = "image";
		this.Voice = new Media(MediaId);
	}
}
