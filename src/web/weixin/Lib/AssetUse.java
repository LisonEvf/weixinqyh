package web.weixin.Lib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.ParseException;
import org.springframework.dao.EmptyResultDataAccessException;

import web.Model.Asset;
import web.weixin.Dao.WeixinDao;
import web.weixin.Model.Weixin;
import web.weixin.Model.Menu.Button;
import web.weixin.Model.Menu.Menu;
import web.weixin.Model.Message.MessageType;
import web.weixin.Model.Message.News;
import web.weixin.Model.Message.NewsMsg;
import web.weixin.Model.Message.ReplyMsg;
import web.weixin.Model.Message.TextMsg;
import web.weixin.Service.WeixinException;

public class AssetUse {
public static final String AgentID = "2";
	
	public static ReplyMsg Reply(Map<String,Object> getMsg) throws WeixinException{
		switch(getMsg.get("MsgType").toString()){
		case MessageType.MESSAGE_TEXT://文本消息
			String content = getMsg.get("Content").toString();
			switch(content){
			case "1":
				return new TextMsg(getMsg,"这是");
			case "创建菜单":
				Weixin weixin = new Weixin();
				try {
					weixin.createMenu(AssetEnter.Menu(), AssetEnter.AgentID);
				} catch (ParseException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return new ReplyMsg(getMsg);
			default://模糊查询
				try{
				List<Asset> assetlist = WeixinDao.SelectAsset(content);
				return new TextMsg(getMsg,assetlist.get(0).getAssetName());
				}catch(EmptyResultDataAccessException e){
					return new TextMsg(getMsg,"查询结果为空");
				}
			}
		case MessageType.MESSAGE_IMAGE://图片消息
			return new ReplyMsg(getMsg);
		case MessageType.MESSAGE_VOICE://语音消息
			return new ReplyMsg(getMsg);
		case MessageType.MESSAGE_VIDEO://视频消息
			return new ReplyMsg(getMsg);
		case MessageType.MESSAGE_SHORTVIDEO://小视频消息
			return new ReplyMsg(getMsg);
		case MessageType.MESSAGE_LOCATION://地理位置消息
			return new ReplyMsg(getMsg);
		case MessageType.MESSAGE_LINK://链接消息
			return new ReplyMsg(getMsg);
		case MessageType.MESSAGE_EVENT://事件
			switch(getMsg.get("Event").toString()){
			//接受事件
			case MessageType.EVENT_SUBSCRIBE://用户关注事件
				return new ReplyMsg(getMsg);
			case MessageType.EVENT_UNSUBSCRIBE://用户取消关注事件
				return new ReplyMsg(getMsg);
			case MessageType.EVENT_LOCATION://进入应用上报地理位置事件
//				String Latitude = getMsg.get("Latitude").toString();//纬度
//				String Longitude = getMsg.get("Longitude").toString();//经度
//				String Precision = getMsg.get("Precision").toString();//精度
				return new ReplyMsg(getMsg);
				//上报菜单事件
			case MessageType.EVENT_CLICK://点击菜单拉取消息的事件推送
				switch(getMsg.get("EventKey").toString()){
				case "1":
					return new ReplyMsg(getMsg);
				default:
					throw new WeixinException("未定义的点击菜单："+getMsg.get("EventKey").toString());
				}
			case MessageType.EVENT_VIEW://点击菜单跳转链接的事件推送
				switch(getMsg.get("EventKey").toString()){
				case "1":
					//void
					break;
				default:
					throw new WeixinException("未定义的链接菜单："+getMsg.get("EventKey").toString());
				}
			case MessageType.EVENT_SCANCODE_PUSH://扫码推事件的事件推送
				switch(getMsg.get("EventKey").toString()){
				case "1":
					@SuppressWarnings("unchecked")
					Map<String,Object> ScanCodeInfo = (Map<String, Object>) getMsg.get("ScanCodeInfo");
					String ScanResult = ScanCodeInfo.get("ScanResult").toString();
//					String ScanType = ScanCodeInfo.get("ScanType").toString();
					ScanResult = ScanResult.substring(ScanResult.indexOf(",")+1, ScanResult.length());
					return new TextMsg(getMsg,ScanResult);
				case "2":
					return new TextMsg(getMsg,"");
				default:
					throw new WeixinException("未定义的扫码推菜单："+getMsg.get("EventKey").toString());
				}
			case MessageType.EVENT_SCANCODE_WAITMSG://扫码推事件且弹出“消息接收中”提示框的事件推送
				switch(getMsg.get("EventKey").toString()){
				case "1":
					@SuppressWarnings("unchecked")
					Map<String,Object> ScanCodeInfo = (Map<String, Object>) getMsg.get("ScanCodeInfo");
					String ScanResult = ScanCodeInfo.get("ScanResult").toString();
//					String ScanType = ScanCodeInfo.get("ScanType").toString();
					ScanResult = ScanResult.substring(ScanResult.indexOf(",")+1, ScanResult.length());
					try{
						Asset asset = WeixinDao.SelectAssetByID(ScanResult);
						News news = new News(asset.getAssetName(),MessageLib.AssetDescription(asset));
						List<News> newslist = new ArrayList<News>();
						newslist.add(news);
						return new NewsMsg(getMsg,newslist);
						}catch(EmptyResultDataAccessException e){
							return new TextMsg(getMsg,"查询结果为空");
						}
				case "2":
					return new TextMsg(getMsg,"");
				default:
					throw new WeixinException("未定义的带‘消息接受中’的扫码推菜单："+getMsg.get("EventKey").toString());
				}
			case MessageType.EVENT_PIC_SYSPHOTO://弹出系统拍照发图的事件推送
				return new ReplyMsg(getMsg);
			case MessageType.EVENT_PIC_PHOTO_OR_ALBUM://弹出拍照或者相册发图的事件推送
				return new ReplyMsg(getMsg);
			case MessageType.EVENT_PIC_WEIXIN://弹出微信相册发图器的事件推送
				return new ReplyMsg(getMsg);
			case MessageType.EVENT_LOCATION_SELECT://弹出地理位置选择器的事件推送
				return new ReplyMsg(getMsg);
			case MessageType.EVENT_ENTER_AGENT://成员进入应用的事件推送
				return new ReplyMsg(getMsg);
			case MessageType.EVENT_BATCH_JOB_RESULT://异步任务完成事件推送
				return new ReplyMsg(getMsg);
			default:
				throw new WeixinException("未知事件:"+getMsg.get("Event").toString());
			}
		default :
			throw new WeixinException("未知消息类型:"+getMsg.get("MsgType").toString());
		}
		
	}
	
	public static Menu Menu(){
		return new Menu(
				new Button("扫码查询").SCANCODE_WAITMSG(),
				new Button("新购入库").SCANCODE_WAITMSG(),
				new Button("资产报废").SCANCODE_WAITMSG()
						);
	}
}
