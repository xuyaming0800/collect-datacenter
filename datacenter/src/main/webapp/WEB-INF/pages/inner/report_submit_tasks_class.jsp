<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
  	function list(page) {
  		qStartDate = $("#dtp_input1").val();
  		qEndDate = $("#dtp_input2").val();
  		qTimeRange = $(":radio[id='_time_range']:checked").val();
  		if(qTimeRange==4){
  			if(qStartDate.length==0||qEndDate.length==0){
  				alert('开始时间或者结束时间都不能为空!');
  				return ;
  			}
  			if(qStartDate>qEndDate){
  	  			alert('开始时间必须小于结束时间!');
  	  			return ;
  	  		}
  		}
  		if(undefined == qStartDate) {
  			qStartDate =null;
  		}
  		if(undefined == qEndDate) {
  			qEndDate =null;
  		}
  		if(undefined == qTimeRange) {
  			qTimeRange = null;
  		}
  		if(undefined == page){
  			page = 1;
  		}
  		$.post("<%=request.getContextPath()%>/report/report_submit_tasks_class/query.html",
			{'page':page,
  			'qStartDate':qStartDate,
  			'qEndDate':qEndDate,
			'qTimeRange':qTimeRange
			},
			function(data){
				var containerBody = $("#bodyid").empty();
				var htm = "";
				data = $.parseJSON(data);
				var list=data.list;
				if(list != null && list.length > 0) {
					$.each(list,function(i,n){
						var _date;
						if(qTimeRange==3){
							_date=(new Date()).Format("yyyy-MM-dd");
					    }else{
					    	_date=n._date;
					    }
					    htm +=  '<tr>'
		    			+ '<td>' + _date + '</td>'
		    			+ '<td>' + n.sall + '</td>'
		    			+ '<td>' + n.s1 + '</td>'
		    			+ '<td>' + n.s2 + '</td>'
		    			+ '<td>' + n.s3 + '</td>'
		    			+ '<td>' + n.s4 + '</td>'
		    			+ '<td>' + n.s5 + '</td>'
		    			+ '<td>' + n.s6 + '</td>'
		    			+ '<td>' + n.s7 + '</td>'
		    			+ '<td>' + n.s8 + '</td>'
		    			+ '<td>' + n.s9 + '</td>'
		    			+ '<td>' + n.s10 + '</td>'
		    			+ '<td>' + n.s11 + '</td>'
		    			+ '<td>' + n.s12 + '</td>'
		    			+ '<td>' + n.s13 + '</td>'
		    			+ '</tr>';
					});
				//如果有数据修改当前页数
					containerBody.html(htm);
				}else {
					containerBody.html("<tr><td colspan='15'>未查询到数据<td></tr>");
				}
		});
  	}
	function queryDataTaskClass() {
  		list();
  		var element = $('#bp-3-element-lg');
        var options = {
        	size:"large",
            bootstrapMajorVersion:3,
            currentPage:1,
            numberOfPages:5,
            onPageClicked:function(event, originalEvent, type, page){
            	list(page);
            }
        }
		$.ajax({
			url: "<%=request.getContextPath()%>/report/report_submit_tasks_class/query.html?page=1&qTimeRange="+qTimeRange+"&qStartDate="+qStartDate+"&qEndDate="+qEndDate,
			dataType: "json",
			success: function(data){
				if(data.pageCount){
					 options.totalPages=data.pageCount%10==0?(data.pageCount/10):(data.pageCount/10+1);
					 element.bootstrapPaginator(options);
				}
			}
		});
  	}
	
	function exprotExcel() {
		qDate = $("#dtp_input2").val();
  		status = $("#statusId").val();
  		if('-1' == status) {
  			alert("请选择【统计类型】！");
  			return ;
  		}
  		if(undefined == qDate) {
  			qDate =null;
  		}
  		window.open('<%=request.getContextPath()%>/report/report_class_collect_tasks/exprotExcel.html?qDate='+qDate+'&status='+status);
	}
</script>

</head>

<body>
	<div id='batch_pay_form'></div>
	<!-- Modal -->
	<div id="containerId" class="container-fluid">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">分类统计</h3>
			</div>
			<div class="panel-body">
				<table class="table table-striped">
					<thead>
						<tr>
							<td colspan="15">
								<div class="panel panel-primary">
									<div class="panel-body">
										<table class="table">
											<tr>
												<td>时间范围:</td>
												<td><input type="radio" name="_time_range" id="_time_range"  value="1" />天</td>
												<td><input type="radio" name="_time_range" id="_time_range" value="2"  />月</td>
												<td><input type="radio" name="_time_range" id="_time_range" value="3"  />所有</td>
												<td><input type="radio" name="_time_range" id="_time_range" value="4"  />自定义</td>
												<td>
														<div class="form-group">
											                <div class="input-group date form_date col-md-5" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input1" data-link-format="yyyy-mm-dd">
											                    <input class="form-control" size="16" type="text" value="" readonly>
											                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
																<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
											                </div>
											                <input type="hidden" id="dtp_input1" value="" />
											            </div>	
											    </td>
											   <td>
											   	       <div class="form-group">
											                <div class="input-group date form_date col-md-5" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
											                    <input class="form-control" size="16" type="text" value="" readonly>
											                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
																<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
											                </div>
															<input type="hidden" id="dtp_input2" value="" />
											            </div>	
											   </td>
											</tr>
											<tr>
												<td colspan="15" style="text-align: right">
													<button type="button" class="btn btn-primary" onclick="javascript:queryDataTaskClass();">查询</button>
												</td>
											</tr>
										</table>
									</div>
								</div>
							</td>
						</tr>
					<!-- 	<tr>
							<td colspan="7">
								<button id="reportSubmitId" type="button" class="btn btn-info" onclick="javascript:exprotExcel();">导出</button>
							</td>
						</tr> -->
						<tr>
							<td>日期</td>
							<td>总数</td>
							<td>交通标志牌</td>
							<td>楼顶广告</td>
							<td>两面立柱</td>
							<td>LED</td>
							<td>绿化带灯箱</td>
							<td>公交站亭</td>
							<td>墙体广告位</td>
							<td>过路天桥</td>
							<td>三面立柱</td>
							<td>侧牌</td>
							<td>公共自行车亭</td>
							<td>灯箱</td>
							<td>指路牌灯箱</td>
						</tr>
					</thead>
					<tbody id="bodyid">
			    	</tbody>
					<tfoot>
						 <tr>
							<td colspan="15" style="text-align: right">
								<div>
									<ul id="bp-3-element-lg" class="pagination pagination-lg">
									</ul>
								</div> 
							</td>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
		<script type="text/javascript">
		$(function(){
			$('.form_date').datetimepicker({
		        language:  'zh-CN',
		        weekStart: 1,
		        todayBtn:  1,
				autoclose: 1,
				todayHighlight: 1,
				startView: 2,
				minView: 2,
				forceParse: 0
		    });
		}
		)
	</script>
</body>
</html>
