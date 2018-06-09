<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ page import="java.sql.*"%>
<%@ page import="com.hbut.dao.*"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String userNO = request.getParameter("UserNO");
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
select.head{
	height:32px;
	display: inline-block;
/* 	margin-left: 5px; */
}
</style>
  </head>
  
  <div style="margin-top: 20px;margin-left:0px;margin-right: 22px;min-width:1000px">
		
		<h3>当前班级</h3>
					<select class="head" id = "scheduleClassNO" name="scheduleClassNO">
  							<option value="WU">请选择</option>
  							<%ResultSet classRs = ClassDao.queryClass(); %>
  							<%while(classRs != null && classRs.next() ){ %>
  								<option value="<%=classRs.getString("ClassNO")%>">
  									<%=classRs.getString("Grade")+classRs.getString("Major")+classRs.getString("Ind") %>
  								</option>
  							<%} %>
  						</select>
		  
		  <div style="margin-top:40px;margin-right:20px;min-width:960px;margin-top: 0px;">
			<iframe id="hiddenframe" frameborder="0" width=95%  height=83% >
				<!-- 	frameborder="0" 无边框，1表示有边框 -->
			</iframe>
		</div>
		  
	</div>
	
	<script language="JavaScript">
	$(function () {
		$("select[name='scheduleClassNO']").bind("change",function () {
			var scheduleClassNO = $("#scheduleClassNO option:selected").val();
// 			alert(scheduleClassNO);
			var url = "putupdateSchedule.action?"+"&scheduleClassNO="+scheduleClassNO;
			var frame = document.getElementById("hiddenframe"); 
			frame.src = url;
		})
	});
	</script>
	
</html>
