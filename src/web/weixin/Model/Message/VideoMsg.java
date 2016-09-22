package web.weixin.Model.Message;

import java.util.Map;

public class VideoMsg extends ReplyMsg{
	protected Video Video;

	public VideoMsg(Map<String, Object> postData,Video Video) {
		super(postData);
		this.MsgType = "video";
		this.Video = Video;
	}
}
