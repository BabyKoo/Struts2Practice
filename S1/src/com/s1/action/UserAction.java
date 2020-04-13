package com.s1.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.s1.entity.User;

public class UserAction {
	User user = new User();
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	ActionContext context = ActionContext.getContext();
	Map<String, Object> session = context.getSession();

	public String signup() {
		if (user.getName().isEmpty() || user.getPsd().isEmpty())
			return "input";
		else
			return "signupSuccess";
	}

	public String signin() {
//		name=(String)session.get("name");
//		psd=(String)session.get("psd");
		System.out.println("UA "+user.getName());
		System.out.println("UAP "+user.getPsd());
		if ("Hok".equals(user.getName()) && "123".equals(user.getPsd())) {
			session.put("msg", "Signin Success");
			session.put("errorMsg", "");
			session.put("name", user.getName());
			String uName=(String)session.get("name");
			System.out.println("UA "+uName);
			return "signinSuccess";
		} else
			return "signin";
	}
}
