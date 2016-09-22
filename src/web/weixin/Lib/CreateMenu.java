package web.weixin.Lib;

import java.io.IOException;

import org.apache.http.ParseException;

import web.weixin.Model.Weixin;
import web.weixin.Service.WeixinException;

public class CreateMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Weixin weixin = new Weixin();
		try {
			System.out.println(weixin.createMenu(AssetEnter.Menu(), AssetEnter.AgentID));
		} catch (ParseException | IOException | WeixinException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
