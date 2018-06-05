<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ page import="java.sql.*"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String userNO = request.getParameter("UserNO");
String[][] timeTable = (String[][])request.getAttribute("timeTable");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <link rel="Shortcut Icon" href="/HbutClassSys/icons/Home/imgTitle.png" />
<script src="<%=basePath%>script/jQuery/jquery.min.js"
	type="text/javascript"></script>
<script src="<%=basePath%>script/jQuery/jquery.easyui.min.js"
	type="text/javascript"></script>
<script src="<%=basePath%>script/jQuery/global.js"
	type="text/javascript"></script>
<link href="<%=basePath%>styles/jQuery/easyui.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>styles/Admin/News/newsIcon.css"
	rel="stylesheet" type="text/css" />
<link href="<%=basePath%>styles/jQuery/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=basePath%>script/showTime.js"></script>
<script type="text/javascript"
	src="<%=basePath%>script/InputCheck/InputCheck.js"></script>
<link href="<%=basePath%>styles/popbox.css" rel="stylesheet" type="text/css">
<style type="text/css">
td.tdHead {
	min-width: 60px;
	vertical-align: middle;
	text-align: center;
}
td.tdBody {
	min-width: 60px;
	min-height: 60px;
	vertical-align: middle;
	text-align: center;
}
</style>
  </head>
  
  <div style="margin-top: 20px;margin-left:0px;margin-right: 22px;min-width:1000px">
		
		<h3>课程信息</h3>
		  
 		 <form id="detailForm"  action="<%=basePath %>/actionTeacher/addCourse" method="post" >

		<div>
			<table class="table table-striped table-bordered"
				style="width:99%;min-width:1070px;margin-right: 22px;">
				
				<tr>
					<td class="tdLeft"><span style="font-size:16px;"><strong>课程编号：</strong></span></td>
					
					<td >
					<input type="text" class="datepicker" name="CourseNO" id="CourseNO" 
						style="width:350px;height:36px;margin-left:5px;margin-top:12px;"maxlength="10" >
					</td>
					
				</tr>
				
				<tr>
					<td class="tdLeft"><span style="font-size:16px;"><strong>课程名称：</strong></span></td>
					
					<td >
					<input type="text" class="datepicker" name="CourseName" id="CourseName" 
						style="width:350px;height:36px;margin-left:5px;margin-top:12px;"maxlength="10" >
					</td>
					
				</tr>
				
				<tr>
					<td class="tdLeft"><span style="font-size:16px;"><strong>课程类型：</strong></span></td>
					
					<td >
						<select style="width:350px;height:36px;margin-left:5px;margin-top:12px;margin-bottom:12px;" id="CourseType" name="CourseType">
							<option value="1">公共基础课</option>
							<option value="2">学科基础课</option>
							<option value="3">公选课</option>
							<option value="4">重修课</option>
						</select>
					</td>
					
				</tr>
				
				<tr>
					<td class="tdLeft"><span style="font-size:16px;"><strong>课程学分：</strong></span></td>
					
					<td >
					<input type="text" class="datepicker" name="Credit" id="Credit" 
						style="width:350px;height:36px;margin-left:5px;margin-top:12px;"maxlength="10" >
					</td>
					
				</tr>
				
				<tr>
					<td class="tdLeft"><span style="font-size:16px;"><strong>课程学时：</strong></span></td>
					
					<td >
					<input type="text" class="datepicker" name="CourseTime" id="CourseTime" 
						style="width:350px;height:36px;margin-left:5px;margin-top:12px;"maxlength="10" >
					</td>
					
				</tr>
					
			</table>
		</div>
		<div
			style="margin-left:auto;margin-right:auto;width:200px;margin-top: 20px;">
			<input type="submit" value="添加" id="submit"
				style="font-size:16px;border-radius:20px;width:80px;height:40px;margin-left:50px;" />
		</div>
	</form>
	
	</div>
</html>
