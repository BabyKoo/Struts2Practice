<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="首页"%>
<!DOCTYPE html>
<html>
<head>
<%-- 导入站点全局首部--%>
<%@ include file="/site-head.jsp"%>
</head>
<body onload="siteInit()" id="index-body">
	<%@ include file="/site-header.jsp"%>
	<div class="ms-Dialog" style="display: block;">
		<div class="ms-Dialog--lgHeader"></div>
		<div class="ms-PanelDefaultExample ms-PanelExample">
			<button class="ms-Button" onclick="javascript: window.location.href='./signup.jsp'">
				<span class="ms-Button-label">注册</span>
			</button>
			&nbsp;&nbsp;
			<button class="ms-Button ms-Button--primary"
				onclick="javascript: window.location.href='./signin.jsp'">
				<span class="ms-Button-label">登录</span>
			</button>
		</div>
	</div>
</body>
</html>