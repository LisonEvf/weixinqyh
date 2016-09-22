package web.Service;

import org.springframework.web.servlet.ModelAndView;

import web.Model.User;

public interface LoginService {
	public ModelAndView doLogin(User user,String loginurl);
}
