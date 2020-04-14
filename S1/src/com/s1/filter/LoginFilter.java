package com.s1.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebFilter(filterName = "LoginFilter", urlPatterns = { "/studentsManagement" })
public class LoginFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest frequest = (HttpServletRequest) request;
		HttpServletResponse fresponse = (HttpServletResponse) response;
		if (frequest.getRequestURI().indexOf("/studentsManagement") != -1) {// 访问studentsManagement目录
			if (frequest.getSession().getAttribute("LOGINED_USER") == null) {// 若登录信息为空
				System.out.println("UnL");
				fresponse.sendRedirect("/S1/signin.jsp");// 则返回登录页
			} else {
				System.out.println("L");
				chain.doFilter(request, response);
			}
		}
		else chain.doFilter(request, response);
	}
}
