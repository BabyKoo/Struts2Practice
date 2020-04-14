<%@page import="com.s1.dao.*"%>
<%@page import="com.s1.entity.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="删除"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<%-- 导入站点全局首部--%>
<%@ include file="/site-head.jsp"%>
</head>
<body onload="siteInit()">
	<%@ include file="/site-header.jsp"%>
	<%
		int id = Integer.parseInt(request.getParameter("stuId"));
		StudentDao sd = new StudentDao();
		boolean consq = sd.deleteStudentById(id);
	%>
	<div class="ms-Dialog" style="display: block;">
		<div class="ms-Dialog--lgHeader"></div>
		<div class="ms-PanelDefaultExample ms-PanelExample">
			<%
				if (consq) {
			%>
			<div class="ms-Dialog--lgHeader">
				删除成功, ID:
				<%=id%></div>
			<%
				;
				} else {
			%>
			<div class="ms-Dialog--lgHeader">删除失败</div>
			<%
				;
				}
			%>
		</div>
	</div>
</body>
</html>