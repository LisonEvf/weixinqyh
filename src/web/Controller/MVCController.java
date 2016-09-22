package web.Controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import web.Dao.UserDao;
import web.Model.User;
import web.Service.implement.LoginServiceImpl;
import web.Service.implement.SelectAssetServiceImpl;
@Controller
public class MVCController {
	
	@Resource
	LoginServiceImpl loginservice;
	

	@RequestMapping("index")
	public ModelAndView dologin(User user){
		String loginurl="login";
		return loginservice.doLogin(user,loginurl);
	}
	
	@Resource
	SelectAssetServiceImpl assetservice;
	
	@RequestMapping("select")
	public ModelAndView selectAsset(String keyword){
		String asseturl="asset";
		return assetservice.SelectAsset(asseturl,keyword);
	}
	
	@RequestMapping("asset")
	public String Asset(){
		return "asset";
	}
	
	@Autowired
	private UserDao userDao;
	@RequestMapping("adminuser")
	public ModelAndView AdminUser(){
		String url="adminuser";
		return new ModelAndView(url,"list",userDao.SelectUser());
	}
	
	
	
	
	@RequestMapping("building")
	public String Building(){
		return "building";
	}
}
