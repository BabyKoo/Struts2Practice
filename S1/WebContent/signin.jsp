<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="登录"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<head>
<%-- 导入站点全局首部--%>
<%@ include file="/site-head.jsp"%>
</head>
<body onload="siteInit()">
<%@ include file="/site-header.jsp"%>
<div class="ms-Dialo" id="main-block">
        <s:form action="/user_signin.action" method="get">
            <div class="error"><s:property value="#session.errorMsg"/></div>
            <div class="ms-TextField" onload="TextField()">
                <label class="ms-Label">用户名</label> <input
                    class="ms-TextField-field" type="text" value="" placeholder=""
                    name="name">
            </div>
            <div class="ms-TextField" onload="TextField()">
                <label class="ms-Label">密码</label> <input class="ms-TextField-field"
                    type="password" value="" placeholder="" name="psd">
            </div>
            <input class="ms-Button ms-Button--primary" type="submit" value="确认"
                name="submit"> <input class="ms-Button" type="reset"
                value="重新填写" name="reset">
        </s:form>
    </div>
</body>
</html>