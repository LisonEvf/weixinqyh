package web.weixin.Model;

public class QYURL {
	public static String ACCESS_TOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=CORPID&corpsecret=CORPSECRET";
	public static String CREATE_MENU_URL = "https://qyapi.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN&agentid=AGENTID";
	public static String CREATE_AETAGENT_URL = "https://qyapi.weixin.qq.com/cgi-bin/agent/set?access_token=ACCESS_TOKEN";
	public static String UPLOAD_URL = "https://qyapi.weixin.qq.com/cgi-bin/material/add_material?agentid=AGENTID&type=TYPE&access_token=ACCESS_TOKEN";
	public static String CREATE_DEPARTMENT_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token=ACCESS_TOKEN";
	public static String UPDATE_DEPARTMENT_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/update?access_token=ACCESS_TOKEN";
	public static String DELETE_DEPARTMENT_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/delete?access_token=ACCESS_TOKEN";

}
