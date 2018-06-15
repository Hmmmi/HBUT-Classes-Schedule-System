<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ page import="java.sql.*"%>
<%@ page import="com.hbut.dao.*"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String userNO = request.getParameter("UserNO");
String[] section = {"第1-2节<br>8:20-9:55","第3-4节<br>10:15-11:50","第5-6节<br>14:00-15:35","第7-8节<br>15:55-17:30","第NI节<br>18:30-20:55"};
String[] week = {"星期一","星期二","星期三","星期四","星期五","星期六","星期天"};
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
		
		<h3>选课信息</h3>
		  
 		 	<div style="margin-top: 20px;margin-left:0px;margin-right: 22px;min-width:200px">
 		 <table id="previewTab" border = "1" class="table table-striped table-bordered"  width=25%  >
  			<tr>
  				<td class="tdHead" ></td>
  				<td class="tdHead" ><strong>名称</strong></td>
  				<td class="tdHead" ><strong>老师</strong></td>
  				<td class="tdHead" ><strong>人数</strong></td>
  				<td class="tdHead" ><strong>地点</strong></td>
  				<td class="tdHead" ><strong>时间</strong></td>
  				<td class="tdHead" ><strong>节次</strong></td>
  				<td class="tdHead" ><strong>星期</strong></td>
  			</tr>
  			<% ResultSet rs = ElectiveClassDao.queryEelectiveClass(); 
  				while(rs != null && rs.next() ){ %>
  				<tr>
  					<td class="tdBody" >
  						<input name = "data" id="data" type="radio" style="margin-left:0px;margin-bottom: 10px;" value="<%=rs.getString("SelectClassNO")%>"/>
  					</td>
  					<td class="tdBody" > <%= rs.getString("CourseName") %> </td>
  					<td class="tdBody" > <%= rs.getString("TeacherName") %> </td>
  					<td class="tdBody" > <%= rs.getString("PeopleNum") %> </td>
  					<td class="tdBody" > <%= rs.getString("RoomNO") %> </td>
  					<td class="tdBody" > <%= rs.getString("StartWeek") %>-<%= rs.getString("endWeek") %> 周</td>
  					<td class="tdBody" > <%= section[Integer.valueOf(rs.getString("Section"))] %> </td>
  					<td class="tdBody" > <%= week[Integer.valueOf(rs.getString("WeekNum"))] %> </td>
  				</tr> 
  			<%} %>
  		</table>
	
<!-- 	<div align="center"  style="margin-left:auto;margin-right:auto;width:200px;margin-top: 20px;"> -->
<!-- 		<input type="button" id="submit" value="汇总" onclick="location.href='/ZsGljSystem/actionEvent/eventCollection.action'" -->
<!-- 			style=" width:62px;height:30px;margin-left: 0px;" /> -->
		<!--  input type="button" value="返回" id="return"
			   style="font-size:16px;border-radius:20px;width:80px;height:40px;" /> -->
<!-- 	</div> -->
	</div>
	<div class="clear"></div>
	
	</div>
</html>
