package com.s1.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.s1.entity.User;

public class LoginInterceptor extends AbstractInterceptor {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3441705012475649618L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Itp begin. ");
//		Map<String, Object> session=arg0.getInvocationContext().getSession();
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		String action = arg0.getInvocationContext().getName();
		System.out.println(action);
		User login_user = (User) session.get("LOGIN_USER");// Map<String, Object>
		session.put("errorMsg", "");
		if (action.equals("user_signin") || action.equals("user_signup"))
			return arg0.invoke();
		if (login_user == null || login_user.getId() == -1) {
			session.put("errorMsg", "Not signed in yet. ");
			return Action.LOGIN;// "login"
//			return arg0.invoke();//放行
		} else {
			System.out.println("LI " + login_user.getId());
			System.out.println("Itp end. ");
			return arg0.invoke();// 放行
		}
//		return arg0.invoke();//放行
	}

	@Override
	public String interceptor(ActionInvocation paramInvocation) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
