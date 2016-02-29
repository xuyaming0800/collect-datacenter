<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>审核列表</title>
<style>
.table {
	width: 100%;
	max-width: 100%;
	margin-bottom: 0;
}
</style>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=IMad2T4yqXPoGZ0zyufzlgO5"></script>
<script type="text/javascript">
	function addMapOverlay() {
  		map.clearOverlays();
	    if (document.createElement('canvas').getContext) {  // 判断当前浏览器是否支持绘制海量点
	  		var bigData=[];
	  		status = $(":radio[id='_audit']:checked").val();
	  		if(undefined == status) {
	  			status =null;
	  		}
	  		system=$("#selectSys").val();
	  		if(undefined == status) {
	  			status =null;
	  		}
	    	$.post("<%=request.getContextPath()%>/map/map_audit_task/query.html",
				{
					status : status,
					system : system
				},
				function(data) {
					data = $.parseJSON(data);
					if (data != null && data.length > 0) {
						$.each(data, function(i, n) {
							var inData = [];
							inData.push(n.lon);
							inData.push(n.lat);
							bigData.push(inData);
						});
						var points = []; // 添加海量点数据
						for (var i = 0; i < bigData.length; i++) {
							points.push(new BMap.Point(
									bigData[i][0],
									bigData[i][1]));
						}
						var options = {
							size : BMAP_POINT_SIZE_SMALL,
							shape : BMAP_POINT_SHAPE_STAR,
							color : '#d340c3'
						}
						var pointCollection = new BMap.PointCollection(
								points, options); // 初始化PointCollection
						pointCollection.addEventListener('click',
								function(e) {
// 									alert('单击点的坐标为：' + e.point.lng+ ',' + e.point.lat); // 监听点击事件
								});
						map.addOverlay(pointCollection); // 添加Overlay
					}
				});
		} else {
			alert('请在chrome、safari、IE8+以上浏览器查看本示例');
		}

	}
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row" style="height: 10px;">
			<div class="col-xs-12 col-md-12">
				<div class="panel panel-default">
					<div id=""
						style="width: 100%;overflow: hidden;margin:0;font-family:'微软雅黑';">
						<table class="table table-striped">
							<thead>
								<tr>
									<td colspan="2">
										<div class="panel panel-primary">
											<div class="panel-body">
												<table class="table">
													<tr>
														<td><font>项目：</font><select id="selectSys" class="form-control"
															style="display: inline;width: 50%">
																<option value="657092850172821504">全国LED大屏广告</option>
																<option value="1">易牌广告</option>
																<option value="3">经济环境</option>
																<option value="4">广告监测</option>
														</select></td>
														<td><font>省：</font><select class="form-control"
															style="display: inline;width: 50%">
																<option>北京</option>
																<option>上海</option>
																<option>天津</option>
														</select></td>
														<td><font>市：</font><select id="selectCity" class="form-control"
															style="display: inline;width: 50%">
																<option selected="selected">北京</option>
																<option>上海</option>
																<option>天津</option>
														</select></td>
														<td><input type="radio" name="_audit" id="_audit"
															value="1" />审核中</td>
														<td><input type="radio" name="_audit" id="_audit"
															value="3" />审核成功</td>
														<td><input type="radio" name="_audit" id="_audit"
															value="4" />审核失败</td>
														<td><input type="radio" name="_audit" id="_audit"
															value="8" />申诉中</td>
														<td>
															<button type="button" class="btn btn-primary"
																onclick="javascript:addMapOverlay();">查询</button>
														</td>
													</tr>
												</table>
											</div>
										</div>
									</td>
								</tr>
							</thead>
						</table>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12 col-md-12">
				<div class="panel panel-default">
					<div class="panel-body">
						<div id="allmap"
							style="width: 100%;overflow: hidden;margin:0;font-family:'微软雅黑';"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var map;
		function loadMap(city){
			//计算baiduMap的高度
			function resizeBaiduMap() {
				var newHeight = $(window).innerHeight()
						- $("#allmap").offset().top - 95;
				$("#allmap").height(newHeight);
			}
			//计算baiduMap的高度
			resizeBaiduMap();
			$(window).resize(resizeBaiduMap);
			// 百度地图API功能
			map = new BMap.Map("allmap"); // 创建Map实例
// 			map.centerAndZoom(new BMap.Point(116.404, 39.915), 12);
			map.centerAndZoom(city, 12); // 设置中心点坐标和地图级别
// 			map.setCurrentCity(city); // 设置地图显示的城市 此项是必须设置的
			map.enableScrollWheelZoom(true); //开启鼠标滚轮缩放
			map.addControl(new BMap.MapTypeControl()); //添加地图类型控件
			map.addControl(new BMap.ScaleControl({
				anchor : BMAP_ANCHOR_TOP_LEFT
			}));// 左上角，添加比例尺
			map.addControl(new BMap.NavigationControl()); //左上角，添加默认缩放平移控件
		}
		$(function() {
			var city=$("#selectCity").find("option:selected").text();
			loadMap(city);
			$('#selectCity').change(function(){ 
				 city=$("#selectCity").find("option:selected").text();
				 loadMap(city);
			}) 
		})
	</script>
</body>
</html>
