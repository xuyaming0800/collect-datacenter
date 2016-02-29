<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>客户中心</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
</head>
<body>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap-theme.min.css">
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css" />
	<div class="head ">
		<div class="header ">
			<div class="logo">
				<a href="#">&nbsp;</a>
			</div>
			<div class="nav_s">
				<span><a href="#" class="name">尊敬的 <shiro:principal /></a>&nbsp;欢迎您！今天是2015年08月20号 星期四 &nbsp;<a href="<%=request.getContextPath()%>/security/logout.html" class="name">安全退出</a> </span>
			</div>
			<nav>
				<div class="nav" id="ccc-nav">
					<ul>
						<li><a href="#" class="home">首页</a></li>
						<li class="dropdown all-camera-dropdown"><a href="#" class="muban">测试项目模板 <b class="caret"></b></a>
						<ul class="sub-menu">
								<li class="dropdown"><a href="#">广告拍拍</a>
									<ul class="sub-menu">
										<li><a href="javascript:go2Page('<%=request.getContextPath()%>/myitems/baseinfo/itemInfo.html')">基本信息</a></li>
										<li><a href="javascript:go2Page('<%=request.getContextPath()%>/security/test.html')">区域统计</a></li>
										<li><a href="javascript:go2Page('<%=request.getContextPath()%>/myitems/report/classifyStatistics.html')">分类统计</a></li>
										<li><a href="#">成果导出</a></li>
										<li><a href="javascript:go2Page('<%=request.getContextPath()%>/myitems/map/dataShow.html')">数据展示</a></li>
									</ul>
								</li>
								<li><a href="#">广告监测</a></li>
						</ul></li>
						<li class="dropdown all-camera-dropdown">
						<a href="#" class="dropdown-toggle ziliao on" data-toggle="dropdown">我的项目 <b class="caret"></b></a>
						<ul class="sub-menu">
								<li class="dropdown"><a href="#">项目一</a>
									<ul class="sub-menu">
										<li><a href="#">基本信息</a></li>
										<li><a href="javascript:go2Page('<%=request.getContextPath()%>/security/test.html')">区域统计</a></li>
										<li><a href="#">分类统计</a></li>
										<li><a href="#">成果导出</a></li>
										<li><a href="#">数据展示</a></li>
									</ul>
								</li>
								<li><a href="#">项目二</a></li>
								<li><a href="#">项目三</a></li>
						</ul></li>
						<li class="dropdown all-camera-dropdown"><a href="#" class="xiaoxi">个人中心 <b class="caret"></b></a>
							<ul class="sub-menu">
								<li><a href="javascript:go2Page('<%=request.getContextPath()%>/user/userInfo.html')">我的资料</a></li>
							</ul>
						</li>
						<li><a href="#" class="download">下载中心</a></li>
						<li><a href="#" class="fankui">信息反馈</a></li>

					</ul>
				</div>
			</nav>
		</div>
	</div>
	
	

	<iframe id="subPage" width="100%" height="100%"></iframe>
	<!--页尾 开始-->
	<div class="footer" >
		<div>Copyright (C) 数聚联盟 2015-2020, All Rights Reserved</div>
	</div>
	<!--页尾 结束-->
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="<%=request.getContextPath()%>/js/jquery-1.11.3.min.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/ie10-viewport-bug-workaround.js"></script>
	<script src="<%=request.getContextPath()%>/js/offcanvas.js"></script>
	<script type="text/javascript" charset="utf-8">
		function go2Page(_url) {
			$('#subPage').attr('src', _url);
		}
		$(function() {
			$('.dropdown').hover(function() {
				$(this).children('.sub-menu').slideDown(200);
			}, function() {
				$(this).children('.sub-menu').slideUp(200);
			});
			$('#subPage').css({ 
				'min-height' : $(window).outerHeight() - 222,
				'border' : 0
			});
		});
	</script>
</body>
</html>
