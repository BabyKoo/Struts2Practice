<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.opensymphony.xwork2.ActionContext, java.util.*, com.s1.entity.Student"
	info="查询结果"%>
<%@page import="java.util.Iterator"%>
<!DOCTYPE html>
<html>
<head>
<%-- 导入站点全局首部--%>
<%@ include file="/site-head.jsp"%>

</head>
<body onload="siteInit()">
	<%@ include file="/site-header.jsp"%>
	<%
		ActionContext context = ActionContext.getContext();
        Map<String, Object> sess = context.getSession();
        ArrayList<Student> list=(ArrayList<Student>)sess.get("Result");
//         if(list.size()>0)
//             out.print(list.get(0).getStuName());
        Iterator<Student> it = list.iterator();
	%>
	<table class="ms-Table cent" id="main-table">
		<thead>
			<tr>
				<th>唯一识别码</th>
				<th>学号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>入学日期</th>
				<th>院系</th>
				<th>班级</th>
				<th>GPA</th>
				<th><i class="ms-Icon ms-Icon--ChangeEntitlements"
					aria-hidden="true"></i></th>
				<th><i class="ms-Icon ms-Icon--Delete" aria-hidden="true"></i></th>
			</tr>
		</thead>
		<tbody>
		<%
		while (it.hasNext()) {
            Student stu = it.next();
		%>
			<tr>
				<th><%=stu.getStuId()%></th>
				<th><%=stu.getStuNo()%></th>
				<th><%=stu.getStuName()%></th>
				<th><%=stu.getStuGender()%></th>
				<th><%=stu.getAdmissionDate()%></th>
				<th><%=stu.getDpart()%></th>
				<th><%=stu.getStuClass()%></th>
				<th><%=stu.getGpa()%></th>
				<th>
					<button class="ms-Button cent"
						onclick="javascript:window.location='./modify.jsp?stuId=<%=stu.getStuId()%>'">
						<span class="ms-Button-label"><i
							class="ms-Icon ms-Icon--DeleteRows" aria-hidden="true"></i>&nbsp;&nbsp;修改</span>
					</button>
				</th>
				<th>
					<button class="ms-Button cent"
						onclick="javascript:if(confirm('确定要删除(ID: gua<%=stu.getStuId()%>)吗?')) window.location='./delete.jsp?stuId=<%=stu.getStuId()%>'">
						<span class="ms-Button-label"><i
							class="ms-Icon ms-Icon--DeleteRows" aria-hidden="true"></i>&nbsp;&nbsp;删除</span>
					</button>
				</th>
			</tr>
			<%;} %>
		</tbody>
	</table>
</body>
</html>