package web.weixin.Lib;

import java.util.Map;

import web.weixin.Model.Message.ReplyMsg;
import web.weixin.Service.WeixinException;

public class AgentUtil {
	
	public static ReplyMsg Reply(Map<String, Object> getMsg,String agentid) throws WeixinException{
		switch(agentid){
		case AssetEnter.AgentID :
			return AssetEnter.Reply(getMsg);
		case "":
			return null;
		default:
			return null;
		}			
	}
}
