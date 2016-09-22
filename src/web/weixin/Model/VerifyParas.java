package web.weixin.Model;

import javax.servlet.http.HttpServletRequest;

public class VerifyParas {
	private String msg_signature;
	private String timestamp;   
	private String nonce;    
	private String echostr;
	public VerifyParas(HttpServletRequest request){
		this.msg_signature = request.getParameter("msg_signature");    
		this.timestamp = request.getParameter("timestamp");   
		this.nonce = request.getParameter("nonce");    
		this.echostr = request.getParameter("echostr"); 
	}
	public String getMsg_signature() {
		return msg_signature;
	}
	public void setMsg_signature(String msg_signature) {
		this.msg_signature = msg_signature;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getNonce() {
		return nonce;
	}
	public void setNonce(String nonce) {
		this.nonce = nonce;
	}
	public String getEchostr() {
		return echostr;
	}
	public void setEchostr(String echostr) {
		this.echostr = echostr;
	}
	

}
