package com.s1.action;

import com.opensymphony.xwork2.ActionSupport;

public class Hello extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2689506994563287093L;
	Hello(){}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return "success";
	}
	public String Test() {
		return "success";
	}
}
