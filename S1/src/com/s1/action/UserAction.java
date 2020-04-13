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
		if (user.getName().isEmpty() || user.getPsd().isEmpty()) {
			session.put("errorMsg", "User name and password could not be empty.");
			return "input";
		} else {
			session.put("errorMsg", "");
			if (ud.insertUser(user) == -1) {
				session.put("errorMsg", "Unkonwn error occur. ");
				return "input";
			} else
				return "signupSuccess";
		}

	}

	public String signin() {
		System.out.println("UA " + user.getName());
		System.out.println("UAP " + user.getPsd());
		if (ud.getUserByPassword(user.getName(), user.getPsd()) != null) {
			session.put("msg", "Signin Success");
			session.put("errorMsg", "");
			session.put("name", user.getName());
			String uName = (String) session.get("name");
			System.out.println("UA " + uName);
			return "signinSuccess";
		} else {
			session.put("errorMsg", "Wrong user name or password.");
			return "login";
		}
	}
}
