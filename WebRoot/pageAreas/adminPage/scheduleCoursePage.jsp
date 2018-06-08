<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ page import="java.sql.*"%>
<%@ page import="com.hbut.dao.*"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String userNO = request.getParameter("UserNO");
// String[][] timeTable = (String[][])request.getAttribute("timeTable");
String[] section = {"第1-2节<br>8:20-9:55","第3-4节<br>10:15-11:50","第5-6节<br>14:00-15:35","第7-8节<br>15:55-17:30","第NI节<br>18:30-20:55"};
// String value = "数据库原理与应用<br>16计算机科学与技术<br>3-103<br>1-12周<br>";
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
	min-width: 200px;
	vertical-align: middle;
	text-align: center;
}
td.tdBody {
	min-width: 200px;
	min-height: 60px;
	vertical-align: middle;
	text-align: center;
}
select.tdIn{
	width:70%;
	height:32px
}
</style>
  </head>
  
  <div style="margin-top: 20px;margin-left:0px;margin-right: 22px;min-width:1000px">
		
		<h3>当前班级</h3>
					<select>
  							<option value="WU">请选择</option>
  							<%ResultSet classRs = ClassDao.queryClass(); %>
  							<%while(classRs != null && classRs.next() ){ %>
  								<option value="<%=classRs.getString("ClassNO")%>">
  									<%=classRs.getString("Grade")+classRs.getString("Major")+classRs.getString("Ind") %>
  								</option>
  							<%} %>
  						</select>
		  
 		 <table id="previewTab" border = "1" class="table table-striped table-bordered"  width=95% height=85% >
  			<tr >
  				<td class="tdHead"  style="min-width:60px"><strong>   </strong></td>
  				<td class="tdHead" ><strong>星期一</strong></td>
  				<td class="tdHead" ><strong>星期二</strong></td>
  				<td class="tdHead" ><strong>星期三</strong></td>
  				<td class="tdHead" ><strong>星期四</strong></td>
  				<td class="tdHead" ><strong>星期五</strong></td>
  				<td class="tdHead" ><strong>星期六</strong></td>
  				<td class="tdHead" ><strong>星期天</strong></td>
  			</tr>
  			
  			<%for(int i = 0 ; i < 5 ; i++){ %>
  				<tr>
  				
  					<td class="tdBody"  style="min-width:60px"><%=section[i] %> </td>
  					<%for(int j = 0 ; j < 7 ; j++){ %>
  						<td class="tdBody" > 
  						课程
  						<select class = "tdIn">
  							<option value="WU">请选择</option>
  							<%ResultSet courseRs = CourseDao.queryCourse(); %>
  							<%while(courseRs != null && courseRs.next() ){ %>
  								<option value="<%=courseRs.getString("CourseNO")%>">
  									<%=courseRs.getString("CourseName") %>
  								</option>
  							<%} %>
  						</select>
  						
  						<br>
  						老师
  						<select class = "tdIn">
  							<option value="WU">请选择</option>
  							<%ResultSet teacherRs = TeacherDao.queryTeacher(); %>
  							<%while(teacherRs != null && teacherRs.next() ){ %>
  								<option value="<%=teacherRs.getString("TeacherNO")%>">
  									<%=teacherRs.getString("TeacherName") %>
  								</option>
  							<%} %>
  						</select>
  						<br>
  						地点
  						<select class = "tdIn"  id="Room<%=i%><%=j%>">
  							<option value="WU">请选择</option>
  							<%ResultSet roomRs = RoomDao.queryRoom(); %>
  							<%while(roomRs != null && roomRs.next() ){ %>
  								<option value="<%=roomRs.getString("RoomNO")%>">
  									<%=roomRs.getString("RoomNO") %>
  								</option>
  							<%} %>
  						</select>
  						<br>
  						周数
  						<select style="width:31%;height:28px;margin-left:0px;margin-top:12px;margin-bottom:12px;">
  						<option value="WU">-</option>
  						<%for(int k=1;k<21;k++){ %>
  							<option value="<%=k%>"><%=k %></option>
  						<%} %>
  						
  						</select>
  						-
  						<select style="width:31%;height:28px;margin-left:0px;margin-top:12px;margin-bottom:12px;">
  							<option value="WU">-</option>
  							<%for(int k=1;k<21;k++){ %>
  								<option value="<%=k%>"><%=k %></option>
  							<%} %>
  						</select>
  						 </td>
  					<%} %>
  				</tr>
  			<%} %>

  		</table>
	
	<div align="center"  style="margin-left:auto;margin-right:auto;width:200px;margin-top: 20px;">
		<input type="button" id="submit" value="提交" onclick=""
			style=" width:62px;height:30px;margin-left: 0px;" />
<!-- 		<!--  input type="button" value="返回" id="return" -->
<!-- 			   style="font-size:16px;border-radius:20px;width:80px;height:40px;" /> --> 
	</div>
	</div>
</html>
