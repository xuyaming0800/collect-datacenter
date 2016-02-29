<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
    var cpage;
  	function list(page) {
  		qDateStart = $("#dtp_input1").val();
  		qDateEnd = $("#dtp_input2").val();
  		qTimeRange = $(":radio[id='_time_range']:checked").val();
  		systemtype=$("#systemtypeId").val();
  		function GetPercent(num, total) { 
  			num = parseFloat(num); 
  			total = parseFloat(total); 
  			if (isNaN(num) || isNaN(total)) { 
  				return "-"; 
  			} 
  			return total <= 0 ? "0%" : (Math.round(num / total * 10000) / 100.00 + "%"); 
  		} 
  		if(qTimeRange==4){
  			if(qDateStart.length==0||qDateEnd.length==0){
  				alert('开始时间或者结束时间都不能为空!');
  				return ;
  			}
  			if(qDateStart>qDateEnd){
  	  			alert('开始时间必须小于结束时间!');
  	  			return ;
  	  		}
  		}
  		if(undefined == qDateStart) {
  			qDateStart =null;
  		}
  		if(undefined == qDateEnd) {
  			qDateEnd =null;
  		}
  		if(undefined == qTimeRange) {
  			qTimeRange =null;
  		}
  		if(undefined == page){
  			page = 1;
  		}
  		if(undefined == systemtype) {
  			systemtype =null;
  		}
  		$.post("<%=request.getContextPath()%>/report/report_rate_audit_tasks/query.html",
			{'page':page,
  			 'qTimeRange':qTimeRange,
  			 'qDateStart':qDateStart,
  			 'qDateEnd':qDateEnd,
  			  systemtype:systemtype
			},
			function(data){
				var containerBody = $("#bodyid").empty();
				var htm = "";
				data = $.parseJSON(data);
				if(data != null && data.length > 0) {
					$.each(data,function(i,n){
						var _date;
						if(qTimeRange==3){
							_date=(new Date()).Format("yyyy-MM-dd");
						}
						if(qTimeRange==2){
							_date=n._date;
						}
					    htm +=  '<tr>'
		    			+ '<td>' + _date + '</td>'
		    			+ '<td>' + GetPercent(n.first_audit_pass_num,n.first_audit_num) + '</td>'
// 		    			+ '<td>' + GetPercent(n.inspection_num-n.auto_inspection_num,n.inspection_num) + '</td>'
		    			+ '<td>' + GetPercent(n.inspection_pass_num,n.inspection_num) + '</td>'
		    			+ '<td>' + GetPercent(n.appeal_num,n.audit_fail_num+(n.first_audit_num-n.first_audit_pass_num)) + '</td>'
		    			+ '<td>' + GetPercent(n.appeal_pass_num,n.appeal_num) + '</td>'
		    			+ '</tr>';
					});
				//如果有数据修改当前页数
					$("#frTaskNext").show();
					containerBody.html(htm);
				}else {
					$("#frTaskNext").hide();
					containerBody.html("<tr><td colspan='6'>未查询到数据<td></tr>");
				}
				if(1 == cpage){
					$("#frTaskPre").hide();
				}else {
					$("#frTaskPre").show();
				}
				$("#pageId").val(page);
		});
  	}
  	list();
  	function queryUserCollectTasks() {
  		list();
  	}
  	function firstPageAlert() {
		alert("已经是第一页");
	}
	function lastPageAlert() {
		alert("已经是最后一页");
	}
  	//前一页
	function previous(tp){
		if(1 == $("#pageId").val()) {
			firstPageAlert();
			return;
		}
		cpage = $("#pageId").val() - 1;
		list(cpage);
	}
	//后一页
	function next(tp){
		cpage = parseInt($("#pageId").val()) + 1;
		list(cpage);
	}
	
</script>

</head>

<body>
	<div id='audit_rate_form'></div>
	<!-- Modal -->
	<div id="containerId" class="container-fluid">
		<input type="hidden" id="pageId" value="1">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">任务提交状态</h3>
			</div>
			<div class="panel-body">
				<table class="table table-striped">
					<thead>
						<tr>
							<td colspan="6">
								<div class="panel panel-primary">
									<div class="panel-body">
										<table class="table">
											<tr>
												<td>时间范围:</td>
<!-- 												<td><input type="radio" name="_time_range" id="_time_range"  value="1" disabled/>天</td> -->
												<td><input type="radio" name="_time_range" id="_time_range" value="2"  />月</td>
												<td><input type="radio" name="_time_range" id="_time_range" value="3"  />所有</td>
												<td><font>项目名：</font><select id="systemtypeId" name="systemtype" class="form-control"
															style="display: inline;width: 50%">
																<option value="657092850172821504">全国LED大屏广告</option>
																<option value="1">易牌广告</option>
																<option value="3">经济环境</option>
																<option value="4">广告监测</option>
														</select></td>
<!-- 												<td><input type="radio" name="_time_range" id="_time_range" value="4"  />自定义</td> -->
									<!-- 			<td>
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
											   </td> -->
											</tr>
											<tr>
												<td colspan="7" style="text-align: right">
													<button type="button" class="btn btn-primary" onclick="javascript:queryUserCollectTasks();">查询</button>
												</td>
											</tr>
										</table>
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td>日期</td>
							<td>初审通过率</td>
<!-- 							<td>抽检率</td> -->
							<td>抽检通过率</td>
							<td>申诉率</td>
							<td>申诉成功率</td>
						</tr>
					</thead>
					<tbody id="bodyid">
			    	</tbody>
					<tfoot>
						<tr>
							<td colspan="6">
								<nav>
									<ul class="pager">
										<li><a id="frTaskPre" href="javascript:previous(0);">前一页</a></li>
										<li><a id="frTaskNext" href="javascript:next(0);">后一页</a></li>
									</ul>
								</nav>
							</td>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
	
<!-- 	<script type="text/javascript">
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
	</script> -->
	</body>
</html>
