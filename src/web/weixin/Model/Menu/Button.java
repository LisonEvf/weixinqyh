package web.weixin.Model.Menu;

import web.weixin.Model.Message.MessageType;

public class Button {
	private String name;
	protected String type;
	private String key;
	
	public Button(String name){
		this.name = name;
	}

	public Button CLICK(){
		this.type = MessageType.EVENT_CLICK;
		return this;
	}
	
	public Button SCANCODE_PUSH(){
		this.type = MessageType.EVENT_SCANCODE_PUSH;
		return this;
	}
	
	public Button SCANCODE_WAITMSG(){
		this.type = MessageType.EVENT_SCANCODE_WAITMSG;
		return this;
	}
	
	public Button PIC_SYSPHOTO(){
		this.type = MessageType.EVENT_PIC_SYSPHOTO;
		return this;
	}
	
	public Button PIC_PHOTO_OR_ALBUM(){
		this.type = MessageType.EVENT_PIC_PHOTO_OR_ALBUM;
		return this;
	}
	
	public Button PIC_WEIXIN(){
		this.type = MessageType.EVENT_PIC_WEIXIN;
		return this;
	}
	
	public Button LOCATION_SELECT(){
		this.type = MessageType.EVENT_LOCATION_SELECT;
		return this;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}	
}
