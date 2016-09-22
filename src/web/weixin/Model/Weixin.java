package web.weixin.Model;

import java.io.IOException;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.http.ParseException;

import web.weixin.Encryptlib.AesException;
import web.weixin.Encryptlib.WXBizMsgCrypt;
import web.weixin.Model.Menu.Menu;
import web.weixin.Service.HttpClients;
import web.weixin.Service.WeixinException;

public class Weixin extends WXBizMsgCrypt{
	static String token ;
	static String encodingAesKey;
	static String corpId;
	static String corpsecret ;
	
	public  void setToken(String token) {
		Weixin.token = token;
	}

	public static void setEncodingAesKey(String encodingAesKey) {
		Weixin.encodingAesKey = encodingAesKey;
	}

	public static void setCorpId(String corpId) {
		Weixin.corpId = corpId;
	}

	public void setCorpsecret(String corpsecret) {
		Weixin.corpsecret = corpsecret;
	}

	public Weixin(){
		super(token, encodingAesKey, corpId);
	}
	
	public String VerifyURL(VerifyParas verify) throws AesException{
		return super.VerifyURL(verify.getMsg_signature(),verify.getTimestamp(),verify.getNonce(),verify.getEchostr());
		
	}
	public String DecryptMsg(VerifyParas verify,String postData) throws AesException{
		return super.DecryptMsg(verify.getMsg_signature(), verify.getTimestamp(), verify.getNonce(), postData);
	}
	public String EncryMsg(VerifyParas verify,String postData) throws AesException{
		return super.EncryptMsg(postData, verify.getTimestamp(), verify.getNonce());
	}
	
	/*
	 * 请求AccessToken
	 */
	public static AccessToken getAccessToken() throws ParseException, IOException, WeixinException{
		AccessToken token = new AccessToken();
//		String url = QYURL.ACCESS_TOKEN_URL.replace("CORPID",corpId).replace("CORPSECRET",corpsecret);
		String url = QYURL.ACCESS_TOKEN_URL.replace("CORPID","wx940aec4b632b03ba").replace("CORPSECRET","0IejA57g6_EpRy9poxUvXBoBJFRsIffM_jKTOWdrYnYoE_xE33NwhSh-lKZ1jCkt");
		JSONObject jsonObject = HttpClients.doGet(url);
		try{
			token.setToken(jsonObject.getString("access_token"));
			token.setExpiresIn(jsonObject.getInt("expires_in"));
		}catch(JSONException e){
			throw new WeixinException(WeixinException.ErrorCode(jsonObject.getInt("errcode")));
		}
		return token;
	}
	/*
	 * 创建菜单
	 */
	public String createMenu(Menu Menu,String agentid) throws ParseException, IOException, WeixinException{
		String menu = JSONObject.fromObject(Menu).toString();
		AccessToken token = getAccessToken();
		String url = QYURL.CREATE_MENU_URL.replace("ACCESS_TOKEN", token.getToken()).replace("AGENTID", agentid);
		String result = "";
		try{
			JSONObject jsonObject = HttpClients.doPost(url, menu);
			result = WeixinException.ErrorCode(jsonObject.getInt("errcode"));
		}catch(JSONException e){
			result = e.getMessage();
		}
		return result;
	}
}