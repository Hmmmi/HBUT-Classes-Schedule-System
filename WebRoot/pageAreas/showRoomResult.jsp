<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ page import="com.hbut.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.hbut.dao.*"%>
<%@ page import= "java.util.List"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
		int queryWeekNum = Integer.valueOf(request.getParameter("queryWeekNum").toString());
		int queryPeopleNum = Integer.valueOf(request.getParameter("queryPeopleNum").toString());
		int queryDayNum = Integer.valueOf(request.getParameter("queryDayNum").toString());
		int querySectionNum = Integer.valueOf(request.getParameter("querySectionNum").toString());
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
	vertical-align: middle;
	text-align: center;
}
</style>
</head>
	<div style="margin-top: 20px;margin-left:0px;margin-right: 22px;min-width:200px">
 		 <table id="previewTab" border = "1" class="table table-striped table-bordered"  width=25%  >
  			<tr>
  				<td class="tdHead" ><strong>教室号</strong></td>
  				<td class="tdHead" ><strong>座位数</strong></td>
  			</tr>
  			<% ResultSet rs = RoomDao.searchRoom(queryWeekNum, queryDayNum, querySectionNum, queryPeopleNum); 
  				while(rs != null && rs.next() ){ %>
  				<tr>
  					<td class="tdBody" > <%= rs.getString("RoomNO") %> </td>
  					<td class="tdBody" > <%= rs.getString("SeatNum") %> </td>
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

	<script type="text/javascript" src="<%=basePath%>script/refreshWindow.js"></script>
<script language="JavaScript" type="text/javascript">
	$(function(){
		var tab = document.getElementById("previewTab");
		var rowNum = tab.rows.length;//行数
		var index = tab.rows[1].cells[0];//首行头元素
 		for(var i = 2;i<=rowNum;i++){
			if(index.innerHTML == tab.rows[i].cells[0].innerHTML){
				tab.rows[i].removeChild(tab.rows[i].cells[0]);//删除相同的单元格元素
				index.rowSpan++;
			}else{
				index = tab.rows[i].cells[0];
				index.style.backgroundColor='#fff';
			}
 		}
	});
</script>

</body>
</html>
