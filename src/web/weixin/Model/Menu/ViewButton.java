package web.weixin.Model.Menu;

import web.weixin.Model.Message.MessageType;

public class ViewButton extends Button{
	private String url;
	private String type;

	public ViewButton(String name,String url) {
		super(name);
		// TODO Auto-generated constructor stub
		this.url = url;
		this.type = MessageType.EVENT_VIEW;
	}

	public String getUrl() {
		return url;
	}

	public String getType() {
		return type;
	}
}
