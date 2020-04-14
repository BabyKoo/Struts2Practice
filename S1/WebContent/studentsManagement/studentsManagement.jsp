<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="学生管理"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<%-- 导入站点全局首部--%>
<%@ include file="/site-head.jsp"%>
</head>
<body onload="siteInit()">
	<%@ include file="/site-header.jsp"%>
	<div class="ms-Dialog" style="display: block;">
		<div class="ms-Dialog--lgHeader">
			欢迎,
			<s:property value="#session.LOGIN_USER.name"></s:property>
		</div>
		<hr>
		<div class="ms-PanelDefaultExample ms-PanelExample">
			<button class="ms-Button">
				<i class="ms-Icon ms-Icon--PeopleAdd" aria-hidden="true"></i>&nbsp;&nbsp;<span
					class="ms-Button-label">查询学生信息</span>
			</button>
			&nbsp;&nbsp;
			<button class="ms-Button ms-Button--primary"
				onclick="javascript: window.location.href='./insertStudent.jsp'">
				<i class="ms-Icon ms-Icon--People" aria-hidden="true"></i>&nbsp;&nbsp;<span
					class="ms-Button-label">新增学生信息</span>
			</button>
			<div class="ms-Panel">
				<button class="ms-Panel-closeButton ms-PanelAction-close">
					<i class="ms-Panel-closeIcon ms-Icon ms-Icon--Cancel"></i>
				</button>
				<div class="ms-Panel-contentInner">
					<p class="ms-Panel-headerText">查询方式</p>
					<div class="ms-Panel-content">
						<div class="ms-font-m">
							<s:a action="query_all">
								<div class="ms-Link" title="">列出全部</div>
                            </s:a>
						</div>
						<div class="ms-font-m">
							<a class="ms-Link" href="./queryStudent.jsp?Type=name" title="">通过姓名</a>
						</div>
						<div class="ms-font-m">
							<a class="ms-Link" href="./queryStudent.jsp?Type=dpart" title="">通过院系</a>
						</div>
						<div class="ms-font-m">
							<a class="ms-Link" href="./queryStudent.jsp?Type=no" title="">通过学号</a>
						</div>
					</div>
				</div>
			</div>
			<hr>
			<s:a action="../user_signout">
				<button class="ms-Button">
					<i class="ms-Icon ms-Icon--SignOut" aria-hidden="true"></i>&nbsp;&nbsp;<span
						class="ms-Button-label">登出</span>
				</button>
			</s:a>
		</div>
	</div>
</body>
</html>