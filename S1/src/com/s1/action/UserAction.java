package com.s1.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.s1.dao.UserDao;
import com.s1.entity.User;

public class UserAction {
	User user = new User();
	UserDao ud = new UserDao();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	ActionContext context = ActionContext.getContext();
	Map<String, Object> session = context.getSession();

	public String signup() {
		user = ud.insertUser(user);
		if (user.getName().isEmpty() || user.getPsd().isEmpty()) {
			session.put("errorMsg", "User name and password could not be empty.");
			return "input";
		} else if (user == null) {
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
		user = ud.getUserByPassword(user.getName(), user.getPsd());
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
}
