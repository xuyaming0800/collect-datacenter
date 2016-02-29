<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head lang="zh_CN">
<meta charset="UTF-8">
<title>注册用户数量变化</title>
<link href="<%=path%>/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div id="main" style="height:800px"></div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width: 1000px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">当日注册用户列表明细</h4>
				</div>
				<div class="modal-body">
					<div class="panel panel-primary">
						<table class="table table-hover table-bordered">
							<thead>
								<tr>
									<th>用户名</th>
									<th>真实姓名</th>
									<th>手机号码</th>
									<th>注册时间</th>
									<th>支付宝帐号</th>
									<th>支付宝户主</th>
									<th>腾讯QQ</th>
									<th>城市</th>
								</tr>
							</thead>
							<tbody id="userDetail">
							</tbody>
						</table>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	<!-- ECharts单文件引入 -->
	<script src="<%=path%>/js/echarts-all.js"></script>
	<script src="<%=path%>/js/jquery-1.10.2.min.js"></script>
	<script src="<%=path%>/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(function() {
			var dayCount = 30;
			var nowDay=new Date();
			//alert(nowDay.Format("yyyyMMdd"));
			var iToDay=nowDay.getDate();
			var iToMon=nowDay.getMonth();
			var iToYear=nowDay.getFullYear();
			var newDay = new Date(iToYear,iToMon,(iToDay-dayCount)); 
			var days;//横坐标集合
			var count;//纵坐标集合
			var keys;//关联字段集合
			//alert(newDay.Format("yyyyMMdd"));
			$.post("<%=basePath%>dimuser/findUserCollectsChange.html", {
				beforeDateInteger : newDay.Format("yyyyMMdd"),
				nowDateInteger : nowDay.Format("yyyyMMdd")
			}, function(data) {
				if (data) {
					data = $.parseJSON(data);
					var regsUserDateUpList = data.regsUserDateUpList;
					count = new Array();//注册量
					days = new Array();//每天的集合
					keys = new Array();
					for (var i = 0; i < dayCount; i++) {//横坐标集合
						var d = new Date(iToYear, iToMon,
								(iToDay - dayCount + i));
						var yearIn = d.getFullYear();
						var dayIn = d.getDate();
						var monthIn = d.getMonth()+1;
						var countIn = 0;
						var flag;
						var index;
						days.push(d.Format("yyyy-MM-dd"));
						for (var j = 0; j < regsUserDateUpList.length; j++) {
							if (yearIn == regsUserDateUpList[j].year
									&& monthIn == regsUserDateUpList[j].month
									&& dayIn == regsUserDateUpList[j].day) {
								flag = true;
								index = j;
							}
						}
						if (flag) {
							count.push(regsUserDateUpList[index].regsCount);
							keys.push(regsUserDateUpList[index].id);
						} else {
							count.push(0);
							keys.push(0);
						}
						flag = false;
						index = 0;
					}
					
					var myChart = echarts.init(document.getElementById('main'));
					myChart.on('click', function (param) {
						var key = keys[param.dataIndex];
						$.post("<%=basePath%>dimuser/findUserCollectsDetail.html", {
							key : key
						}, function(data) {
							$("#userDetail").empty();
							if(data!=null&&data!=""){
								data = $.parseJSON(data);
								$.each(data,function(i,n){
									var cityByTel;
								 	$.ajax({
										url: "http://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel="+(!n.telephone?'':n.telephone),
										dataType: "jsonp",
										success: function(dataBytel){
											if(dataBytel.province){
												$("#cityByTel"+i).text(dataBytel.province);
											}
										}
									});
									$("<tr/>").append("<td>"+(!n.name?'':n.name)+"</td>")
									.append("<td>"+(!n.truename?'':n.truename)+"</td>")
									.append("<td>"+(!n.telephone?'':n.telephone)+"</td>")
									.append("<td>"+new Date(n.create_date).toLocaleDateString()+"</td>")
									.append("<td>"+(!n.alipayaccount?'':n.alipayaccount)+"</td>")
									.append("<td>"+(!n.alipaytruename?'':n.alipaytruename)+"</td>")
									.append("<td>"+(!n.qq?'':n.qq)+"</td>")
									.append("<td id=cityByTel"+i+">"+(!n.city?'':n.city)+"</td>").append("<tr/>").appendTo("#userDetail");
									cityByTel = null;
								});
								$('#myModal').modal('toggle');
							}else{
								alert("参数key值有误");
							}
						});
					});
					
					option = {
						title : {
							text : '注册用户日增长量变化',
							subtext : '默认查询至当前30天内日增长量'
						},
						tooltip : {
							trigger : 'axis'
						},
						legend : {
							data : [ '用户日增长量' ]
						},
						toolbox : {
							show : true,
							feature : {
								mark : {
									show : true
								},
								dataView : {
									show : true,
									readOnly : false
								},
								magicType : {
									show : true,
									type : [ 'line', 'bar' ]
								},
								restore : {
									show : true
								},
								saveAsImage : {
									show : true
								}
							}
						},
						calculable : true,
						xAxis : [ {
							type : 'category',
							boundaryGap : false,
							data : days
						} ],
						yAxis : [ {
							type : 'value',
							axisLabel : {
								formatter : '{value} 人'
							}
						} ],
						series : [ {
							name : '用户日增长量',
							type : 'line',
							data : count,
							markLine : {
								data : [ {
									type : 'average',
									name : '平均值'
								} ]
							}
						} ]
					};
					myChart.setOption(option);
				}
			});
		});
	</script>
</body>
</html>