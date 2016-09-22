package web.weixin.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import web.weixin.Model.VerifyParas;
import web.weixin.Model.Message.News;
import web.weixin.Model.Message.ReplyMsg;

import com.thoughtworks.xstream.XStream;

public class MessageUtil {
	static boolean Debug = true;
	
	public static Map<String, Object> XMLToMap(VerifyParas verify, String postData) throws DocumentException{
		Map<String, Object> map = new HashMap<String, Object>();
		Document doc = DocumentHelper.parseText(postData);
        Element root = doc.getRootElement();
        for (Iterator<?> iterator = root.elementIterator(); iterator.hasNext();) {  
            Element e = (Element) iterator.next();  
            List<?> list = e.elements();  
            if(list.size() > 0){  
                map.put(e.getName(), ElementToMap(e));  
                if(Debug)
                System.out.println(e.getName()+":"+ElementToMap(e));
            }else{
                map.put(e.getName(), e.getText());
                if(Debug)
                System.out.println(e.getName()+":"+e.getText());
            }
        }
        if(Debug)
        	System.out.println("------------------------------------------------------------------");
		return map;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map ElementToMap(Element e){  
        Map map = new HashMap();  
        List list = e.elements();  
        if(list.size() > 0){  
            for (int i = 0;i < list.size(); i++) {  
                Element iter = (Element) list.get(i);  
                List mapList = new ArrayList();  
                  
                if(iter.elements().size() > 0){  
                    Map m = ElementToMap(iter);  
                    if(map.get(iter.getName()) != null){  
                        Object obj = map.get(iter.getName());  
                        if(!obj.getClass().getName().equals("java.util.ArrayList")){  
                            mapList = new ArrayList();  
                            mapList.add(obj);  
                            mapList.add(m);  
                        }  
                        if(obj.getClass().getName().equals("java.util.ArrayList")){  
                            mapList = (List) obj;  
                            mapList.add(m);  
                        }  
                        map.put(iter.getName(), mapList);  
                    }else  
                        map.put(iter.getName(), m);  
                }  
                else{  
                    if(map.get(iter.getName()) != null){  
                        Object obj = map.get(iter.getName());  
                        if(!obj.getClass().getName().equals("java.util.ArrayList")){  
                            mapList = new ArrayList();  
                            mapList.add(obj);  
                            mapList.add(iter.getText());  
                        }  
                        if(obj.getClass().getName().equals("java.util.ArrayList")){  
                            mapList = (List) obj;  
                            mapList.add(iter.getText());  
                        }  
                        map.put(iter.getName(), mapList);  
                    }else  
                        map.put(iter.getName(), iter.getText());  
                }  
            }  
        }else
            map.put(e.getName(), e.getText());
        return map;  
    }  
	
	public static String ReplyMsgToXML(ReplyMsg replymsg){
		XStream xstream = new XStream();
		xstream.alias("xml", replymsg.getClass());
		if(replymsg.MsgType.equals("news"))
			xstream.alias("item", new News().getClass());
		return xstream.toXML(replymsg);
	}

}
