<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ page import="java.sql.*"%>
<%@ page import="com.hbut.dao.*"%>

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
				
<!-- 				<tr> -->
<!-- 					<td class="tdLeft"><span style="font-size:16px;"><strong>课程编号：</strong></span></td> -->
					
<!-- 					<td > -->
<!-- 					<input type="text" name="CourseNO" id="CourseNO"  -->
<!-- 						style="width:350px;height:36px;margin-left:5px;margin-top:12px;"maxlength="10" > -->
<!-- 					</td> -->
					
<!-- 				</tr> -->
				
				<tr>
					<td class="tdLeft"><span style="font-size:16px;"><strong>课程名称：</strong></span></td>
					
					<td >
					<input type="text" class="datepicker" name="CourseName" id="CourseName" 
						style="width:350px;height:36px;margin-left:5px;margin-top:12px;"maxlength="20" >
					</td>
					
				</tr>
				
				<tr>
					<td class="tdLeft"><span style="font-size:16px;"><strong>课程学分：</strong></span></td>
					
					<td >
					<input type="text" class="datepicker" name="Credit" id="Credit" 
						style="width:350px;height:36px;margin-left:5px;margin-top:12px;"maxlength="3" onkeyup="clearNoNum(this)">
					</td>
					
				</tr>
				
				<tr >
					<td class="tdLeft"><span style="font-size:16px;"><strong>课程学时：</strong></span></td>
					
					<td >
					<input type="text"  name="CourseTime" id="CourseTime" 
						style="width:350px;height:36px;margin-left:5px;margin-top:12px;"maxlength="2" onkeyup="value=value.replace(/[^\d]/g,'')">
					</td>
					
				</tr>
				
				<tr id="people" style="display:none;">
					<td class="tdLeft" ><span style="font-size:16px;"><strong>课程人数：</strong></span></td>
					
					<td >
					<input type="text" name="CoursePeople" id="CoursePeople" 
						style="width:350px;height:36px;margin-left:5px;margin-top:12px;"maxlength="3" onkeyup="value=value.replace(/[^\d]/g,'')">
					</td>
					
				</tr>
				
				<tr id="seweek" style="display:none;">
					<td class="tdLeft" ><span style="font-size:16px;"><strong>时&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;间：</strong></span></td>
					
					<td >
							<select  id="startWeek"  name="startWeek"   
						  								 style="width:17.2%;height:36px;margin-left:5px;margin-top:12px;margin-bottom:12px;">
						  			<%for(int k=1;k<21;k++){ %>
						  		<option value="<%=k%>"><%=k %></option>
						  			<%} %>
						  	</select>
						  	-
						  	<select  id="endWeek"  name="endWeek"   
						  								style="width:17.2%;height:36px;margin-left:0px;margin-top:12px;margin-bottom:12px;">
						  					<%for(int k=1;k<21;k++){ %>
						  			<option value="<%=k%>"  ><%=k %></option>
						  					<%} %>
						  	</select>
					</td>
					
				</tr>
				
				<tr id="room" style="display:none;">
					<td class="tdLeft" ><span style="font-size:16px;"><strong>地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;点：</strong></span></td>
					
					<td >
							<select  id="roomNO"  name="roomNO"   
						  								 style="width:36%;height:36px;margin-left:5px;margin-top:12px;margin-bottom:12px;">
						  			<%ResultSet roomRs = RoomDao.queryAllRoom(); %>
						  							<%while(roomRs != null && roomRs.next() ){ %>
						  								<option value="<%=roomRs.getString("RoomNO")%>">
						  									<%=roomRs.getString("RoomNO") %>
						  								</option>
						  							<%} %>
						  	</select>
						  
					</td>
					
				</tr>
				
				<tr id="section" style="display:none;">
					<td class="tdLeft" ><span style="font-size:16px;"><strong>节&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;次：</strong></span></td>
					
					<td >
						<select style="width:350px;height:36px;margin-left:5px;margin-top:12px;margin-bottom:12px;" id="CourseSection" name="CourseSection">
							<option value="0" >1-2节</option>
							<option value="1" >3-4节</option>
							<option value="2" >5-6节</option>
							<option value="3" >7-8节</option>
							<option value="4" >NI节</option>
						</select>
					</td>
					
				</tr>
				
				<tr id="week" style="display:none;">
					<td class="tdLeft" ><span style="font-size:16px;"><strong>星&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;期：</strong></span></td>
					
					<td >
						<select style="width:350px;height:36px;margin-left:5px;margin-top:12px;margin-bottom:12px;" id="CourseWeek" name="CourseWeek">
							<option value="0">星期一</option>
							<option value="1">星期二</option>
							<option value="2">星期三</option>
							<option value="3">星期四</option>
							<option value="4">星期五</option>
							<option value="5">星期六</option>
							<option value="6">星期天</option>
						</select>
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
	
		<script language="JavaScript">
	$(function () {
		$("select[name='CourseType']").bind("change",function () {
			var courseType = $("#CourseType option:selected").val();
			var people = document.getElementById("people");
			var room = document.getElementById("room");
			var seweek = document.getElementById("seweek");
			var section = document.getElementById("section");
			var week = document.getElementById("week");
			if(courseType == 3){
				people.style.display = "";
				room.style.display = "";
				seweek.style.display = "";
				section.style.display = "";
				week.style.display = "";
			}else{
				if( people.style.display != "none" ){
					people.style.display = "none";
				}
				if( room.style.display != "none" ){
					room.style.display = "none";
				}
				if( seweek.style.display != "none" ){
					seweek.style.display = "none";
				}
				if( section.style.display != "none" ){
					section.style.display = "none";
				}
				if( week.style.display != "none" ){
					week.style.display = "none";
				}
			}
		})
	});
	
	function clearNoNum(obj){ 
	    obj.value = obj.value.replace(/[^\d.]/g,"");  //清除“数字”和“.”以外的字符  
	    obj.value = obj.value.replace(/\.{2,}/g,"."); //只保留第一个. 清除多余的  
	    obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$","."); 
	    obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3');//只能输入两个小数  
	    if(obj.value.indexOf(".")< 0 && obj.value !=""){//以上已经过滤，此处控制的是如果没有小数点，首位不能为类似于 01、02的金额 
	        obj.value= parseFloat(obj.value); 
	    } 
    } 
	</script>
	
</html>
