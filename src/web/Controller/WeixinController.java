package web.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.dom4j.DocumentException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.weixin.Encryptlib.AesException;
import web.weixin.Lib.AgentUtil;
import web.weixin.Model.VerifyParas;
import web.weixin.Model.Weixin;
import web.weixin.Model.Message.ReplyMsg;
import web.weixin.Service.MessageUtil;
import web.weixin.Service.WeixinException;

@Controller  
@RequestMapping("weixin")  
public class WeixinController {
	Weixin weixin = new Weixin();
    /** 
     *首次验证
     */  
    @RequestMapping(method = { RequestMethod.GET }/*, produces = "application/xml;charset=UTF-8"*/)  
    public void getRequest(VerifyParas verify, PrintWriter out) {
    	try {
			out.print(weixin.VerifyURL(verify));	
		} catch (AesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        out.flush();  
        out.close();  
    }  
  
    /** 
     * 微信消息的处理
     */  
    @RequestMapping(method = { RequestMethod.POST })  
    public void postRequest(HttpServletRequest request, HttpServletResponse response)  
            throws IOException {

        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）  
        request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8");  
        //接受消息
        VerifyParas verify = new VerifyParas(request);
		InputStream inputStream = request.getInputStream();
		String postData = IOUtils.toString(inputStream);
		try {
			//解密
			postData = weixin.DecryptMsg(verify, postData);
			// 调用核心业务类接收消息、处理消息
			Map<String, Object> XML = MessageUtil.XMLToMap(verify, postData);
			String AgentID = XML.get("AgentID").toString();
			ReplyMsg replymsg = AgentUtil.Reply(XML, AgentID);
	        postData = MessageUtil.ReplyMsgToXML(replymsg);
	        //加密
	        postData = weixin.EncryMsg(verify, postData);
		} catch (AesException | DocumentException | WeixinException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // 响应消息  
        PrintWriter out = response.getWriter();  
        out.print(postData);  
        out.close();  
    }
}
