<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ page import="java.sql.*"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
// String userNO = request.getParameter("UserNO");
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
		
		<h3>教室查询</h3>
		  
 		 <div style="margin-left:0px;margin-top:20px;min-with:570px">
 		 
 		 	<span style="width:5%;font-size:13px;"><strong>周数：</strong></span>
			<select style="width:10%;min-width: 75px;font-size:13px;margin-right: 20px;"
								id="queryWeekNum" name="queryWeekNum">
					<%for(int i = 1 ; i < 20 ; i++){ %>
						<option value=<%= i %> ><%= i %></option>
					<%}//end for %>
			</select>
			
			<span style="width:5%;font-size:13px;"><strong>星期：</strong></span>
			<select style="width:10%;min-width: 75px;font-size:13px;margin-right: 20px;"
								id="queryDayNum" name="queryDayNum">
						<option value="0" >一</option>
						<option value="1" >二</option>
						<option value="2">三</option>
						<option value="3" >四</option>
						<option value="4" >五</option>
						<option value="5" >六</option>
						<option value="6" >天</option>
			</select>
			
			<span style="width:5%;font-size:13px;"><strong>节次：</strong></span>
			<select style="width:10%;min-width: 75px;font-size:13px;margin-right: 20px;"
								id="querySectionNum" name="querySectionNum">
						<option value="1" >1-2节</option>
						<option value="2" >3-4节</option>
						<option value="3" >5-6节</option>
						<option value="4" >7-8节</option>
						<option value="5" >NI节</option>
			</select>
			
			<span style="width:5%;font-size:13px;"><strong>人数：</strong></span>
			<select style="width:10%;min-width: 75px;font-size:13px;margin-right: 20px;"
								id="queryPeopleNum" name="queryPeopleNum">
						<option value="80" >80</option>
						<option value="200" >200</option>
			</select>
			
			<div id ="queryBtn"  style="width:10%;margin-right:0px;display:inline-block;"align="right">
						<input type="button" id="submit" value="查询" onclick="query()"
								style="margin-bottom:12px; width:62px;height:28px;margin-right: 0px;font-size:13px;" />
			</div>
 		 
 		 </div>
 		 
 		 <div style="margin-top:40px;margin-right:20px;min-width:960px;margin-top: 0px;">
			<iframe id="hiddenframe" frameborder="0" width=95%  height=60% >
				<!-- 	frameborder="0" 无边框，1表示有边框 -->
			</iframe>
		</div>
	
	</div>
	
	<script language="JavaScript">
	function query(){
			var queryWeekNum = $("#queryWeekNum option:selected").val();
 			var queryPeopleNum = $("#queryPeopleNum option:selected").val();
 			var queryDayNum = $("#queryDayNum option:selected").val();
 			var querySectionNum = $("#querySectionNum option:selected").val();
// 			alert(queryCompanyID+"-"+queryTypeID+"-"+queryUploadTimeFrom+"-"+queryUploadTimeTo);
			var url = "showResult.action?"+ "&queryWeekNum=" + queryWeekNum
					+ "&queryPeopleNum=" + queryPeopleNum
					+ "&queryDayNum=" + queryDayNum
					+ "&querySectionNum=" + querySectionNum ;
			var frame = document.getElementById("hiddenframe"); 
			frame.src = url;
		}
	</script>
	
</html>
