package web.weixin.Model.Message;

public class News {
	protected String Title;
	protected String Description;
	protected String PicUrl;
	protected String Url;
	
	public News(){
		
	}
	
	public News(String Title){
		this.Title = Title;
	}
	
	public News(String Title,String Description){
		this.Title = Title;
		this.Description = Description;
	}
	
	public News(String Title,String Description,String PicUrl){
		this.Title = Title;
		this.Description = Description;
		this.PicUrl = PicUrl;
	}

	public void setUrl(String url) {
		Url = url;
	}
	

}
