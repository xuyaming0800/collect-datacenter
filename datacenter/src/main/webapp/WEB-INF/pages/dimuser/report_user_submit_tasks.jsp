<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
//     var cpage;
  	function list(page) {
  		qDateStart = $("#dtp_input1").val();
  		qDateEnd = $("#dtp_input2").val();
  		qTimeRange = $(":radio[id='_time_range']:checked").val();
  		username = $("#usernameId").val();
  		systemtype=$("#systemtypeId").val();
  		if(undefined == username) {
  			username =null;
  		}
  		if(undefined == systemtype) {
  			systemtype =null;
  		}
  		/* function GetPercent(num, total) { 
  			num = parseFloat(num); 
  			total = parseFloat(total); 
  			if (isNaN(num) || isNaN(total)) { 
  				return "-"; 
  			} 
  			return total <= 0 ? "0%" : (Math.round(num / total * 10000) / 100.00 + "%"); 
  		}  */
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
  		$.post("<%=request.getContextPath()%>/report/report_user_submit_tasks/query.html",
			{'page':page,
  			 'qTimeRange':qTimeRange,
  			 'qDateStart':qDateStart,
  			 'qDateEnd':qDateEnd,
  			 'username':username,
  			 'systemtype':systemtype
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
		    			+ '<td>' + n.username + '</td>'
		    			+ '<td>' + n.truename + '</td>'
		    			+ '<td>' + n.sall + '</td>'
		    			+ '<td>' + n.s2 + '</td>'
		    			+ '<td>' + n.s3 + '</td>'
		    			+ '<td>' + n.s4 + '</td>'
		    			+ '<td>' + n.s8 + '</td>'
// 		    			+ '<td>' + GetPercent(n.s3,n.s3+n.s4) + '</td>'
		    			+ '</tr>';
					});
					containerBody.html(htm);
				}else {
					containerBody.html("<tr><td colspan='9'>未查询到数据<td></tr>");
				}
 
		});
  	}
  	function queryUserCollectTasks() {
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
			url: "<%=request.getContextPath()%>/report/report_user_submit_tasks/query.html?page=1&username="+username+"&qTimeRange="+qTimeRange+"&qDateStart="+qDateStart+"&qDateEnd="+qDateEnd+"&systemtype="+systemtype,
			dataType: "json",
			success: function(data){
				if(data.pageCount){
					 options.totalPages=data.pageCount%10==0?(data.pageCount/10):(data.pageCount/10+1);
					 element.bootstrapPaginator(options);
				}else{
					 options.totalPages=1;
					 element.bootstrapPaginator(options);
				}
			}
		});
  	}
	
</script>
</head>

<body>
	<div id='batch_pay_form'></div>
	<!-- Modal -->
	<div id="containerId" class="container-fluid">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">任务提交状态</h3>
			</div>
			<div class="panel-body">
				<table class="table table-striped">
					<thead>
						<tr>
							<td colspan="9">
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
														<div class="form-group" style="margin-bottom: 0px;">
											                <div class="input-group date form_date col-md-5" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input1" data-link-format="yyyy-mm-dd">
											                    <input class="form-control" style="width: 140px;" size="16" type="text" value="" readonly>
											                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
																<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
											                </div>
											                <input type="hidden" id="dtp_input1" value="" />
											            </div>	
											    </td>
											   <td>
											   	       <div class="form-group" style="margin-bottom: 0px;">
											                <div class="input-group date form_date col-md-5" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
											                    <input class="form-control"  style="width: 140px;" size="16" type="text" value="" readonly>
											                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
																<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
											                </div>
															<input type="hidden" id="dtp_input2" value="" />
											            </div>	
											   </td>
<!-- 											   	<td><font>用户名:</font></td> -->
												<td><font>用户名:</font><input id="usernameId" type="text" name="username" class="form-control" style="display: inline;width: 50%"></td>
												<td><font>项目名：</font><select id="systemtypeId" name="systemtype" class="form-control"
															style="display: inline;width: 50%">
																<option value="657092850172821504">全国LED大屏广告</option>
																<option value="1">易牌广告</option>
																<option value="3">经济环境</option>
																<option value="4">广告监测</option>
														</select></td>
											</tr>
											<tr>
												<td colspan="10" style="text-align: right">
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
							<td>名称</td>
							<td>昵称</td>
							<td>任务总量</td>
							<td>审核中数量</td>
							<td>审核成功数量</td>
							<td>审核失败数量</td>
							<td>申诉数量</td>
<!-- 							<td>通过率</td> -->
						</tr>
					</thead>
					<tbody id="bodyid">
			    	</tbody>
					<tfoot>
						<tr>
							<td colspan="9" style="text-align: right">
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
