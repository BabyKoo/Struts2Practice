<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="查询"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<%-- 导入站点全局首部--%>
<%@ include file="/site-head.jsp"%>
</head>

<body><%@ include file="/site-header.jsp"%>
	<%
		String type = request.getParameter("Type");
		if (type != null && type.equals("name")) {
	%>
	<div class="ms-Dialo" id="main-block">
		<s:form action="/studentsManagement/query_byName.action" method="get">
			<div class="error">
				<s:property value="#session.errorMsg" />
			</div>
			<div class="ms-TextField" onload="TextField()">
				<label class="ms-Label">学生姓名</label> <input
					class="ms-TextField-field" type="text" value="" placeholder=""
					name="student.stuName">
			</div>
			<input class="ms-Button ms-Button--primary" type="submit" value="确认"
				name="submit">
			<input class="ms-Button" type="reset" value="重新填写" name="reset">
		</s:form>
	</div>
	<%
		;
		} else if (type != null && type.equals("dpart")) {
	%>
	<div class="ms-Dialo" id="main-block">
		<s:form action="/studentsManagement/query_byDpart.action" method="get">
			<div class="error">
				<s:property value="#session.errorMsg" />
			</div>
			<div class="ms-TextField" onload="TextField()">
				<label class="ms-Label">学生院系</label> <input
					class="ms-TextField-field" type="text" value="" placeholder=""
					name="student.stuDpart">
			</div>
			<input class="ms-Button ms-Button--primary" type="submit" value="确认"
				name="submit">
			<input class="ms-Button" type="reset" value="重新填写" name="reset">
		</s:form>
	</div>
	<%
		;
		} else if (type != null && type.equals("no")) {
	%>
	<div class="ms-Dialo" id="main-block">
		<s:form action="/studentsManagement/query_byNo.action" method="get">
			<div class="error">
				<s:property value="#session.errorMsg" />
			</div>
			<div class="ms-TextField" onload="TextField()">
				<label class="ms-Label">学生学号</label> <input
					class="ms-TextField-field" type="text" value="" placeholder=""
					name="student.stuNo">
			</div>
			<input class="ms-Button ms-Button--primary" type="submit" value="确认"
				name="submit">
			<input class="ms-Button" type="reset" value="重新填写" name="reset">
		</s:form>
	</div>
	<%
		;
		} else
	%>
	<div class="ms-Dialo" id="main-block">
		<div class="error">
			<s:property value="#session.errorMsg" />
		</div>
	</div>
	<%
		;
	%>
</body>
</html>