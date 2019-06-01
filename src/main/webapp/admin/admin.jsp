﻿<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>无标题文档</title> <!-- 让超链接后的页面在页面的右下部分显示 -->
	<base target="rightFrame" />
	<link type="text/css" rel="stylesheet"
		href="<%=request.getContextPath()%>/css/common.css" />
	<style type="text/css">
</style>


	<!-- 引入富文本编辑器 -->
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/ckeditor/ckeditor.js"></script>

	<!-- 线性粒子背景特效 -->
	<script type="text/javascript" src="../js/canvas-particle.js"></script>
	<script type="text/javascript">
		window.onload = function() {
			//配置
			var config = {
				vx : 4, //小球x轴速度,正为右，负为左
				vy : 4, //小球y轴速度
				height : 2, //小球高宽，其实为正方形，所以不宜太大
				width : 2,
				count : 100, //点个数
				color : "121, 162, 185", //点颜色
				stroke : "50,50,50", //线条颜色
				dist : 6000, //点吸附距离
				e_dist : 20000, //鼠标吸附加速距离
				max_conn : 10
			//点到点最大连接数
			}

			//调用
			CanvasParticle(config);
		}
	</script>
</head>

<body>
	<div id="mydiv" style="height: 1000px;">
		<!--页面顶部-->
		<jsp:include page="adminTop.jsp"></jsp:include>
		<!--页面中部-->
		<div id="content" class="main-content clearfix">
			<jsp:include page="adminRightbar.jsp"></jsp:include>
			<jsp:include page="adminSidebar.jsp"></jsp:include>
		</div>
		<!--页面底部-->
		<jsp:include page="adminBottom.jsp"></jsp:include>
	</div>
</body>
</html>