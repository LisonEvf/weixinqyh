package web.weixin.Model.Menu;

import web.weixin.Model.Message.MessageType;

public class SubButton extends Button{
	private Button[] sub_button;
	
	public SubButton(String name,Button ...button) {
		super(name);
		this.type = MessageType.EVENT_CLICK;
		this.sub_button = button;
	}
	
	public void setkey(){
		for(int i=0;i<this.sub_button.length;i++){
			this.sub_button[i].setKey(this.getKey()+String.valueOf(i+1));
		}
	}

	public Button[] getSub_button() {
		return sub_button;
	}

}
