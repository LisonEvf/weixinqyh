package web.weixin.Model.Message;

public class Video {
	protected String MediaId;
	protected String Title;
	protected String Description;
	
	public Video(String MediaId,String Title,String Description){
		this.MediaId = MediaId;
		this.Title = Title;
		this.Description = Description;
	}

}
