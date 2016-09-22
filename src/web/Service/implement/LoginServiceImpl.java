package web.Service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import web.Dao.UserDao;
import web.Model.User;
import web.Service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private UserDao loginDao;
	
	@Override
	public ModelAndView doLogin(User user,String loginurl) {
		if(user.getUsername()==null&&user.getPassword()==null)
			return new ModelAndView(loginurl,"error","");
		
		if(user.getUsername()==null||user.getUsername().equals(""))
			return new ModelAndView(loginurl,"error","用户名不能为空");
		
		if(user.getPassword().equals("")||user.getPassword()==null)
			return new ModelAndView(loginurl,"error","密码不能为空");
		
		if(CheckLogin(user)!=null){
			 return new ModelAndView("main");
		}
		if(CheckLogin(user)==null)
			return new ModelAndView(loginurl,"error","用户不存在");
		
		return new ModelAndView(loginurl,"error","用户名和密码不正确");
	} 
	private User CheckLogin(User user){
		User nuser = loginDao.SelectUser(user.getUsername());
		if(nuser.getPassword().equals(user.getPassword()))
			return nuser;
		else
			return null;
	}

}
