<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="Shortcut Icon" href="<%=basePath%>icons/Home/imgTitle.png" /> 
	<title>欢迎使用湖工大排课系统</title>
	<link rel="stylesheet" href="<%=basePath%>styles/reset.css" type="text/css">
	<link rel="stylesheet" href="<%=basePath%>styles/style11.css" type="text/css">
</head>

<body style="background-color: #e3e3e3;">
	<div id="contain">
<!-- 	    <img id="i1" src="<%=basePath%>icons/Login/img14.png"> -->
	    
	    <div id="d1">
	        <h1>湖工大排课系统登录页</h1>
	        <form action="<%=basePath%>actionLogin/login" method="post">
	        	<div class="d10">
	                <label class="l1" for="UserName">身&nbsp;&nbsp;&nbsp;份&nbsp;:</label>
	                <select class="l2" style = "width: 235px;height: 34px;" id="userType" name="userType">
							<option value="1">学生</option>
							<option value="2">教师</option>
							<option value="3">管理员</option>
					</select>
	            </div>
	            <div class="d11">
	                <label class="l1" for="UserName">登录名&nbsp;:</label>
	                <input class="l2" type="text" name="userName" id="userName" />
	            </div>
	            <div class="d12">
	                <label class="l1" for="Password">密&nbsp;&nbsp;&nbsp;码&nbsp;:</label>
	                <input class="l2" type="password" name="userNO" id="userNO" />
	            </div>
	            <div class="d13">
	                <input class="l3" type="submit" value="确&nbsp;&nbsp;定">
	            </div>
	            <div class="d14">
	                <a href="<%=basePath%>pageAreas/login.jsp"><input class="l3" type="button" value="取&nbsp;&nbsp;消"></a>
	            </div>
	        </form>
	    </div>
	</div>
</body>
</html>