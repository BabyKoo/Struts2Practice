<%@page import="com.opensymphony.xwork2.util.finder.ClassFinder.Info"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="注册"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
		<s:form action="/user_signup.action" method="get">
			<div class="ms-TextField" onload="TextField()">
				<label class="ms-Label">用户名</label> <input
					class="ms-TextField-field" type="text" value="" placeholder=""
					name="name">
			</div>
			<div class="ms-TextField" onload="TextField()">
				<label class="ms-Label">密码</label> <input class="ms-TextField-field"
					type="password" value="" placeholder="" name="psd">
			</div>
			<div class="ms-Dropdown" tabindex="0">
				<label class="ms-Label">性别</label> <i
					class="ms-Dropdown-caretDown ms-Icon ms-Icon--ChevronDown"></i> <select
					class="ms-Dropdown-select" name="gender">
					<option value="male">男</option>
					<option value="female">女</option>
				</select>
			</div>
			<div class="ms-TextField" onload="TextField()">
				<label class="ms-Label">邮箱</label> <input class="ms-TextField-field"
					type="email" value="" placeholder="" name="email">
			</div>
			<div class="ms-DatePicker">
				<div class="ms-TextField">
					<label class="ms-Label">生日</label> <i
						class="ms-DatePicker-event ms-Icon ms-Icon--Event"></i> <input
						class="ms-TextField-field" type="text" placeholder="选择日期&hellip;"
						name="birthDate">
				</div>
				<div class="ms-DatePicker-monthComponents">
					<span class="ms-DatePicker-nextMonth js-nextMonth"><i
						class="ms-Icon ms-Icon--ChevronRight"></i></span> <span
						class="ms-DatePicker-prevMonth js-prevMonth"><i
						class="ms-Icon ms-Icon--ChevronLeft"></i></span>
					<div class="ms-DatePicker-headerToggleView js-showMonthPicker"></div>
				</div>
				<span class="ms-DatePicker-goToday js-goToday">回到今天</span>
				<div class="ms-DatePicker-monthPicker">
					<div class="ms-DatePicker-header">
						<div class="ms-DatePicker-yearComponents">
							<span class="ms-DatePicker-nextYear js-nextYear"><i
								class="ms-Icon ms-Icon--ChevronRight"></i></span> <span
								class="ms-DatePicker-prevYear js-prevYear"><i
								class="ms-Icon ms-Icon--ChevronLeft"></i></span>
						</div>
						<div class="ms-DatePicker-currentYear js-showYearPicker"></div>
					</div>
					<div class="ms-DatePicker-optionGrid">
						<span class="ms-DatePicker-monthOption js-changeDate"
							data-month="0">Jan</span> <span
							class="ms-DatePicker-monthOption js-changeDate" data-month="1">Feb</span>
						<span class="ms-DatePicker-monthOption js-changeDate"
							data-month="2">Mar</span> <span
							class="ms-DatePicker-monthOption js-changeDate" data-month="3">Apr</span>
						<span class="ms-DatePicker-monthOption js-changeDate"
							data-month="4">May</span> <span
							class="ms-DatePicker-monthOption js-changeDate" data-month="5">Jun</span>
						<span class="ms-DatePicker-monthOption js-changeDate"
							data-month="6">Jul</span> <span
							class="ms-DatePicker-monthOption js-changeDate" data-month="7">Aug</span>
						<span class="ms-DatePicker-monthOption js-changeDate"
							data-month="8">Sep</span> <span
							class="ms-DatePicker-monthOption js-changeDate" data-month="9">Oct</span>
						<span class="ms-DatePicker-monthOption js-changeDate"
							data-month="10">Nov</span> <span
							class="ms-DatePicker-monthOption js-changeDate" data-month="11">Dec</span>
					</div>
				</div>
				<div class="ms-DatePicker-yearPicker">
					<div class="ms-DatePicker-decadeComponents">
						<span class="ms-DatePicker-nextDecade js-nextDecade"><i
							class="ms-Icon ms-Icon--ChevronRight"></i></span> <span
							class="ms-DatePicker-prevDecade js-prevDecade"><i
							class="ms-Icon ms-Icon--ChevronLeft"></i></span>
					</div>
				</div>
			</div>

			<input class="ms-Button ms-Button--primary" type="submit" value="确认"
				name="submit"> <input class="ms-Button" type="reset"
				value="重新填写" name="reset">
		</s:form>
	</div>

</body>
</html>