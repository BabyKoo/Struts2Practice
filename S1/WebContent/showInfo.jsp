<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="结果"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<%-- 导入站点全局首部--%>
<%@ include file="/site-head.jsp"%>
</head>
<body onload="siteInit()">
<s:fielderror></s:fielderror>
	<div class="error">
		<s:property value="#session.errorMsg" />
	</div>
	<%@ include file="/site-header.jsp"%>
	<div class="ms-Dialog" style="display: block;">
		<div class="ms-Dialog--lgHeader"></div>
		<div class="ms-PanelDefaultExample ms-PanelExample">
			<div class=".ms-Dialog-title">欢迎！</div>
			<br />
			<div class="ms-Label">用户名：</div>
			<s:property value="%{#parameters.name}" />
			<br />
			<div class="ms-Label">密码：</div>
			<s:property value="%{#parameters.psd}" />
			<br />
			<br />
			<button class="ms-Button ms-Button--primary"
				onclick="javascript: window.location.href='./signin.jsp'">
				<span class="ms-Button-label">返回登录</span>
			</button>
		</div>
	</div>
</body>
</html>