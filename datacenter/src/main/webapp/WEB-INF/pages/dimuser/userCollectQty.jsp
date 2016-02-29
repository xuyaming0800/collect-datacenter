<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>

<title>用户采集量</title>

</head>

<body>
<div id="main" style="height:800px"></div>
<script type="text/javascript">
	var myChart;
	var option;
	 function unique(ary){
	        var obj={};
	        for(var i=0;i<ary.length;i++){
	            var cur=ary[i];
	            if(obj[cur]==cur){
	                ary.splice(i,1);
	                i--;
	            }
	            obj[cur]=cur;
	        }
	        return ary;
	    }
	$(function() {
		$.post("<%=basePath%>dimuser/fecthUserCollectQty.html", null, function(data) {
			if(data){
				data=$.parseJSON(data);
				var userName,collectNum,j;
				var taskTimeList=new Array();
				var usrList=new Array();
				var collList=new Array();
				$.each(data, function (i, items) {  //这里的data就是models返回的含有四个集合序列的对象值,通过items加.就可以获取对应的值了
					var taskTime=items.taskTime;
					taskTime=(new Date(taskTime)).Format("MM");
					taskTimeList.push(taskTime);
					var jsonTaskSub=items.uTaskSubList;
					$.each(jsonTaskSub,function(i2,items2){
						var uN=items2.bigName;
						console.log(uN);
						usrList.push(items2.bigName);
						collList.push(items2.collectNum);
						j+=items2.collectNum;
					});
		        });
				if(myChart==null)
					myChart = echarts.init(document.getElementById('main'));
				option = {
					    title : {
					        text: '用户采集量',
					        subtext: '取样-数据仓库'
					    },
					    tooltip : {
					        trigger: 'axis'
					    },
					    legend: {
					        data:unique(taskTimeList)
					    },
					    toolbox: {
					        show : true,
					        feature : {
					            mark : {show: true},
					            dataView : {show: true, readOnly: false},
					            magicType: {show: true, type: ['line', 'bar']},
					            restore : {show: true},
					            saveAsImage : {show: true}
					        }
					    },
					    calculable : true,
					    yAxis : [
					        {
					            type: 'value',
					            splitNumber: j,
					            axisLabel: {
					                formatter: function (value) {
					                    return value + ' 次'
					                }
					            },
					            splitLine: {
					                show: false
					            }
					        }
					    ],
					    xAxis : [
					        {
					            type : 'category',
					            data : usrList
					        }
					    ],
					    series : [
					        {
					            name:unique(taskTimeList),
					            type:'bar',
					            data:collList
					        }
					
					    ]
					};
					myChart.setOption(option);
			}
		});
	});
	
	
</script>
</body>
</html>
