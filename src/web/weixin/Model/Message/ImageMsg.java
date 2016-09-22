package web.weixin.Model.Message;

import java.util.Map;

public class ImageMsg extends ReplyMsg{
	protected Media Image;

	public ImageMsg(Map<String, Object> postData,String MediaId) {
		super(postData);
		this.MsgType = "image";
		this.Image = new Media(MediaId);
	}

}
