package com.s1.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class UserAction {
	private String name;
	private String psd;
	private String gender;
	private String email;
	private String birthDate;
	ActionContext context = ActionContext.getContext();
	Map<String, Object> session = context.getSession();
	
	public UserAction() {
		super();
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPsd() {
		return psd;
	}

	public void setPsd(String psd) {
		this.psd = psd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String signup() {
		if (name.isEmpty() || name.isEmpty())
			return "input";
		else
			return "signupSuccess";
	}

	public String signin() {
//		name=(String)session.get("name");
//		psd=(String)session.get("psd");
		System.out.println("UA "+name);
		System.out.println("UAP "+psd);
		if ("Hokdung".equals(name) && "123".equals(psd)) {
			session.put("msg", "Signin Success");
			session.put("errorMsg", "");
			session.put("name", name);
			String uName=(String)session.get("name");
			System.out.println("UA "+uName);
			return "signinSuccess";
		} else
			return "login";
	}
}
