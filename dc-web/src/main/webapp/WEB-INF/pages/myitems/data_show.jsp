<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<div class="container">
		<div class="list_main">
			<div class="tips">
				已采集任务总数<b> 200 </b>条，合格<b> 150 </b>条，不合格<b> 20 </b>条，审核中<b> 30 </b>条！
			</div>
			<h2 class="list_breadcrumb">
				当前位置：&nbsp;&nbsp;<a href="">我的项目</a>&nbsp;&nbsp;<span class="arial">〉</span>&nbsp;&nbsp;<a
					href="">项目一</a>&nbsp;&nbsp;<span class="arial">〉</span>&nbsp;&nbsp;<a
					href="">数据展示</a>
			</h2>
			<div class="floatleft">
				<span class="lefttext">选择省</span><select class="select"
					name="select"><option>河北</option></select><span class="lefttext">选择市</span><select
					class="select" name="select"><option>石家庄</option></select><span
					class="lefttext">选择状态</span><select class="select" name="select"><option>审核状态</option></select>
				<span class="lefttext">类别</span><select class="select"
					name="select"><option>全部</option></select><input name=""
					type="checkbox" class="checkbox" /><label class="margright">合格</label><input
					name="" type="checkbox" class="checkbox" checked="checked" /><label
					class="margright">不合格</label><input name="" type="checkbox"
					class="checkbox" checked="checked" /><label class="margright">审核中</label><a
					class="btnsizi" href="">查找</a>
			</div>
			<div class="clear"></div>
			<div class="map">
				<img src="images/map.jpg" width="100%" />
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<script type="text/javascript">
	$(document).ready(function() {
        $( '.dropdown' ).hover(
            function(){
                $(this).children('.sub-menu').slideDown(200);
            },
            function(){
                $(this).children('.sub-menu').slideUp(200);
            }
        );
    });
	</script>
</body>
</html>
