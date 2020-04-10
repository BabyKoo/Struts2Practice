package com.s1.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName = "EncodingFilter", urlPatterns = "/*", initParams = {
		@WebInitParam(name = "CharsetEncoding", value = "UTF-8") })
public class EncodingFilter implements Filter {

	private static String encoding; // 定义变量接收初始化的值

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 设置字符编码链锁
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
	}

	// 初始化
	public void init(FilterConfig config) throws ServletException {
		// 接收@WebFilter中的初始参数
		encoding = config.getInitParameter("CharsetEncoding");

	}

}
