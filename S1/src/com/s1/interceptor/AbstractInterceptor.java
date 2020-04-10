package com.s1.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public abstract class AbstractInterceptor implements Interceptor {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3014199984397677195L;
	public void init() {}
	public void destory() {}
	public abstract String interceptor(ActionInvocation paramInvocation) throws Exception;
}
