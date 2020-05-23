package com.s1.action;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.s1.entity.User;
import com.s1.service.impl.UserService;

public class UserAction extends ActionSupport {
	private static final long serialVersionUID = -6866561297494983378L;
	User user = new User();
//  UserService userService=new UserService();
	ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
	UserService userService = (UserService) ctx.getBean("userService");

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	ActionContext context = ActionContext.getContext();
	Map<String, Object> session = context.getSession();

	public String signup() {
		int num = userService.userLogup(user);
		if (user.getName().isEmpty() || user.getPsd().isEmpty()) {
			session.put("errorMsg", "User name and password could not be empty.");
			return "input";
		} else if (num<=0) {
			session.put("errorMsg", "Unkonwn error occur. ");
			return "input";
		} else {
			session.put("errorMsg", "");
			return "signupSuccess";
		}
	}

	public String signin() {
		System.out.println("UA " + user.getName());
		System.out.println("UAP " + user.getPsd());
		user = userService.userLogin(user.getName(), user.getPsd());
		if (user != null) {
			session.put("msg", "Signin Success");
			session.put("errorMsg", "");
			session.put("LOGIN_USER", user);
			User login_user = (User)session.get("LOGIN_USER");
			System.out.println("UID " + login_user.getId());
			return "signinSuccess";
		} else {
			session.put("errorMsg", "Wrong user name or password.");
			return "login";
		}
	}

	public String signout() {
		System.out.println("UAout " + user.getName());
		user=null;
		session.put("msg", "Signout Success");
		session.put("errorMsg", "");
		session.put("LOGIN_USER", null);
		String uName = (String) session.get("name");
		System.out.println("UA " + uName);
		return "login";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
