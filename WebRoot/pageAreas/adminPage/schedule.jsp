<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ page import="java.sql.*"%>
<%@ page import="com.hbut.dao.*"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String[] section = {"第1-2节<br>8:20-9:55","第3-4节<br>10:15-11:50","第5-6节<br>14:00-15:35","第7-8节<br>15:55-17:30","第NI节<br>18:30-20:55"};
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
  
  <form id="detailForm" action=<%=request.getAttribute("action")%> method="post" >
		  
		  <div>
		  
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
  						
  						<%if(timeTable[i][j] != null){ %>
  							<%=timeTable[i][j] %>
  						<%}else{ %>
  							<div>
  												课程
						  						<select id="courseNO<%=i %><%=j %>"  name="courseNO<%=i %><%=j %>"  class = "tdIn">
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
						  						<select id="teacherNO<%=i %><%=j %>"  name="teacherNO<%=i %><%=j %>"   class = "tdIn">
						  							<option value="WU">请选择</option>
						  							<%ResultSet teacherRs = TeacherDao.queryTeacher(j,i); %>
						  							<%while(teacherRs != null && teacherRs.next() ){ %>
						  								<option value="<%=teacherRs.getString("TeacherNO")%>">
						  									<%=teacherRs.getString("TeacherName") %>
						  								</option>
						  							<%} %>
						  						</select>
						  						
						  						<br>
						  						地点
						  						<select class = "tdIn"  id="roomNO<%=i%><%=j%>"  name = "roomNO<%=i%><%=j%>" >
						  							<option value="WU">请选择</option>
						  							<%ResultSet roomRs = RoomDao.queryRoom(j,i); %>
						  							<%while(roomRs != null && roomRs.next() ){ %>
						  								<option value="<%=roomRs.getString("RoomNO")%>">
						  									<%=roomRs.getString("RoomNO") %>
						  								</option>
						  							<%} %>
						  						</select>
						  						
						  						<br>
						  						周数
						  						<select  id="startWeek<%=i %><%=j %>"  name="startWeek<%=i %><%=j %>"   
						  								 style="width:31%;height:28px;margin-left:0px;margin-top:12px;margin-bottom:12px;">
						  						<option value="WU">-</option>
						  						<%for(int k=1;k<21;k++){ %>
						  							<option value="<%=k%>"><%=k %></option>
						  						<%} %>
						  						
						  						</select>
						  						-
						  						<select  id="endWeek<%=i %><%=j %>"  name="endWeek<%=i %><%=j %>"   
						  								style="width:31%;height:28px;margin-left:0px;margin-top:12px;margin-bottom:12px;">
						  							<option value="WU" >-</option>
						  							<%for(int k=1;k<21;k++){ %>
						  								<option value="<%=k%>"  ><%=k %></option>
						  							<%} %>
						  						</select>
  							</div>
  							<%}//end if %>
						  						
  						 </td>
  					<%} %>
  				</tr>
  			<%} %>

  		</table>
  		</div>
		<div
			style="margin-left:auto;margin-right:auto;width:200px;margin-top: 20px;">
			<input type="submit" value="提交" id="submit"
				style="font-size:16px;border-radius:20px;width:80px;height:40px;margin-left:50px;" />
		</div>
		
		</form>
		
	<script language="JavaScript">
	</script>
</html>
