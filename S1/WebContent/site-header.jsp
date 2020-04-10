<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="ms-Grid" dir="ltr" id="header">
	<div class="ms-Grid-row">
		<div class="ms-Grid-col ms-sm6 ms-md4 ms-lg2">
			<div class="ms-ContextualMenu-basic">
				<button class="ms-Button ms-Button--primary">
					<span class="ms-Button-label"> <i
						class="ms-Icon ms-Icon--ExpandMenu" aria-hidden="true"></i>选择功能
					</span>
				</button>
				<ul class="ms-ContextualMenu is-hidden">
					<li class="ms-ContextualMenu-item"><a
						class="ms-ContextualMenu-link" tabindex="1" href="/S1/signup.jsp">注册</a></li>
					<li class="ms-ContextualMenu-item"><a
						class="ms-ContextualMenu-link" tabindex="1"
						href="/S1/signin.jsp">登录</a></li>
				</ul>
			</div>
		</div>
		<div class="ms-Grid-col ms-sm6 ms-md8 ms-lg10 ms-Link"
			id="header-right">
			<i class="ms-Icon ms-Icon--CoffeeScript" aria-hidden="true"></i>&nbsp;<a
				href="/S1/index.jsp" title="首页" class="">Struts2 实验一</a>
		</div>
	</div>
</div>