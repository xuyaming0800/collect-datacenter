<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta name="description" content="">
<meta name="author" content="">

<title>运营分析平台</title>
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/bootstrap-theme.min.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/js/ie-emulation-modes-warning.js"></script>
<style type="text/css">
	body {
		background-color: #666;
	}
</style>
</head>
<body>
    <nav class="navbar navbar-inverse" style="margin-bottom:0px;">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a href="#" class="navbar-brand" style="padding:5px 15px;"><img class="img-responsive center-block" src="<%=request.getContextPath()%>/images/icon.png"></a>
                <span class="navbar-brand">尊敬的 <shiro:principal />，欢迎访问运营分析平台! v4.0</span>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">采集用户维度<span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                        	<li><a href="javascript:go2Page('<%=path%>/report/report_where_user_regs/list.html')"><span>用户信息</span></a></li>
                        	<li><a href="javascript:go2Page('<%=path%>/report/report_user_submit_tasks/list.html')"><span>任务提交状态</span></a></li>
                        	<li class="divider"></li>
                        	<li><a href="javascript:go2Page('<%=path%>/report/report_user_collect_tasks/list.html')"><span>审核明细</span></a></li>
                            <%-- <li><a href="javascript:go2Page('<%=path%>/dimuser/list.html')"><span>用户采集量变化</span></a></li>
                            <li><a href="userCollectList.html" target="_self">采集用户量分布</a></li>
                            <li class="active"><a href="javascript:go2Page('<%=path%>/dimuser/list.html')">采集用户 Top 10</a></li>
                            <li><a href="javascript:go2Page('<%=path%>/dimuser/userCollectsChange.html')">采集用户数量变化</a></li> --%>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">数据维度<span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                        	<li><a href="javascript:go2Page('<%=path%>/report/report_city_user_regs/list.html')"><span>用户分布</span></a></li>
                        	<li><a href="javascript:go2Page('<%=path%>/report/report_day_user_regs/list.html')"><span>用户注册量</span></a></li>
                        	<li class="divider"></li>
                        	<li><a href="javascript:go2Page('<%=path%>/report/report_data_submit_tasks/list.html')"><span>任务提交状态</span></a></li>
                        	<li><a href="javascript:go2Page('<%=path%>/report/report_data_collect_tasks/list.html')"><span>审核明细</span></a></li>
                        	<li class="divider"></li>
                        	<li><a href="javascript:go2Page('<%=path%>/report/report_submit_tasks_class/list.html')"><span>分类统计</span></a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">审核<span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                        	<li><a href="javascript:go2Page('<%=path%>/report/report_rate_audit_tasks/list.html')"><span>审核率</span></a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">数据展示<span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                        	<li><a href="javascript:go2Page('<%=path%>/map/map_audit_task/list.html')"><span>审核状态</span></a></li>
<!--                         	<li><a href="javascript:go2Page('<%=path%>/report/report_rate_audit_tasks/list.html')"><span>采集状态</span></a></li> -->
                        </ul>
                    </li>   
                </ul>
        		<a href="<%=request.getContextPath()%>/logout" class="nav navbar-nav navbar-right">退出</a>
            </div>
        </div>
    </nav>
    <iframe id="subPage" width="100%" height="100%"></iframe>
    <script src="<%=request.getContextPath()%>/js/jquery-1.11.2.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/ie10-viewport-bug-workaround.js"></script>
	<script src="<%=request.getContextPath()%>/js/offcanvas.js"></script>
	<script type="text/javascript">
		function go2Page(_url) {
			$(function() {
				$('#subPage').attr('src', _url);
			});
		}
		function autoResizeIframe() {
			$(function() {
				$('#subPage').css({
					'position' : 'absolute',
					'height' : $(window).outerHeight() - 60,
					'border' : 0
				});
			});
		}
		$(function() {
			$("#bs-example-navbar-collapse-1 > ul > li.active > a > span").click();
			$("#bs-example-navbar-collapse-1 > ul > li").each(function() {
				$(this).click(function() {
					$(this).siblings("li").removeClass("active");
					$(this).addClass("active");
				});
			});
			autoResizeIframe();
			$(window).resize(function() {
				autoResizeIframe();
			});
		});
	</script>
</body>

</html>
