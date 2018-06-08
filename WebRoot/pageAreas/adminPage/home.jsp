<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<title>排课系统-管理员</title>
<script type="text/javascript"
	src="<%=basePath%>script/jQuery/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>script/jQuery/global.js"></script>
<link href="<%=basePath%>styles/HomePage/public.css" rel="stylesheet" type="text/css">
<link rel="Shortcut Icon" href="<%=basePath%>icons/Home/imgTitle.png" />
</head>
<body style="overflow:hidden;">
	<header> 
<!-- 	<img class="i3" href="<%=basePath%>pageAreas/HomePage/home.jsp" -->
<!-- 		src="<%=basePath%>icons/Login/imgTitle.png"> -->
	<h2>
		<span style="color: #fff;font-size: 15px;font-family: Microsoft YaHei, Arial, Helvetica, sans-serif;">欢迎使用，<%=request.getAttribute("UserName")%></span>
	</h2>
	<img class="i4" float="right" src="<%=basePath%>icons/Home/img3.png">
	<h3>
		<a href="<%=basePath%>actionLogin/logout.action">注销</a>
	</h3>
	</header>

	<!-- dcHead 结束 -->
	<div id="dcLeft">
		<div id="menu">
			<ul class="top">
			</ul>
			<ul>
				<li id="liScheduleCoursePage" class="cur"
					onclick="setIframe('liScheduleCoursePage','<%=basePath%>actionAdmin/scheduleCoursePage.action?UserNO=<%= request.getAttribute("UserNO") %>')"><a><i
						class="show"></i><em>手动排课</em></a></li>
			</ul>
<!-- 			<ul> -->
<!-- 				<li id="lisearchRoom" -->
<!-- 					onclick="setIframe('lisearchRoom','<%=basePath%>actionTeacher/searchEmptyRoom')"><a><i -->
<!-- 						class="show"></i><em>教室查看</em></a></li> -->
<!-- 			</ul> -->
			
		</div>
	</div>
	<div id="dcMain" style="padding-bottom: 0px; ">
		<div class="mainBox"
			style="height: auto ! important; min-height: 500px; padding-top: 0px; padding-right: 0px; border-top-width: 30px; margin-top: 0px;padding-bottom: 0px;">
			<Iframe id="iframeAdmin"
				src="<%=basePath%>actionAdmin/scheduleCoursePage.action?UserNO=<%= request.getAttribute("UserNO") %>"   
				width="100%" height="85%" style="margin-bottom: 0px;" scrolling="yes" frameborder="0">
			</iframe>
		</div>

	</div>
	<div class="clear"></div>
	<div id="dcFooter">
		<div id="footer">
			<div class="line"></div>
			<ul><li align = "center">版权所有 © 2017-2018 HBUT，并保留所有权利。</li></ul>
		</div>
	</div>
	<!-- dcFooter 结束 -->
	<div class="clear"></div>
	

	<script language="javascript">
		//设置页面跳转的方法
		function setIframe(liId, iframeSrc) {
			//先初始化所有空间的class属性
			$("#liScheduleCoursePage").removeClass("cur");
			$("#lisearchRoom").removeClass("cur");
// 			$("#liaddCourse").removeClass("cur");
// 			设置跳转页面为iframeSrc,并设置对应的class属性为cur
			$("#iframeAdmin").attr("src", iframeSrc);
			$("#" + liId).addClass("cur");
		}
		//退出系统
		function quit() {
			var url = "/HbutClassSys/login/systemQuit.action";
			$.ajax({
				type : "post",
				url : url,
				cache : false,
				success : function(data, dataStatus) {
					if (dataStatus) {
						self.opener = null;
						self.close();
					}
				}
			});
		}
	</script>
</body>
</html>
