<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
  	function list(page) {
  		qDate = $(":radio[id='_time_range']:checked").val();
  		if(undefined == page){
  			page = 1;
  		}
  		if(undefined == qDate) {
  			qDate =null;
  		}
  		$.post("<%=request.getContextPath()%>/report/report_day_user_regs/query.html",
  			{'page':page,
  			'qDate':qDate
			},
			function(data){
				var containerBody = $("#bodyid").empty();
				var htm = "";
				data = $.parseJSON(data);
				var list=data.list;
				if(list != null && list.length > 0) {
					$.each(list,function(i,n){
						var _date=null;
						if("2"==qDate){
							_date=n.sRegDate;
						}else{
							_date=(new Date(n.regDate)).Format("yyyy-MM-dd");
						}
					    htm +=  '<tr>'
		    			+ '<td>' + _date + '</td>'
		    			+ '<td>' + n.dayTotal + '</td>'
		    			+ '</tr>';
					});
				//如果有数据修改当前页数
					containerBody.html(htm);
				}else {
					containerBody.html("<tr><td colspan='3'>未查询到数据<td></tr>");
				}
		});
  	}
  	function queryUserRegs() {
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
			url: "<%=request.getContextPath()%>/report/report_day_user_regs/query.html?page=1&qDate="+qDate,
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
		window.open('<%=request.getContextPath()%>/report/report_day_user_regs/exprotExcel.html');
	}
</script>

</head>

<body>
	<div id='batch_pay_form'></div>
	<!-- Modal -->
	<div id="containerId" class="container-fluid">
		<input type="hidden" id="pageId" value="1">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">用户注册数</h3>
			</div>
<!-- 			<p class="navbar-text">截止当日共<span id='_daytotal'>95</span>人注册!</p> -->
			<div class="panel-body">
				<table class="table table-striped">
					<thead>
						<tr>
							<td colspan="3">
								<div class="panel panel-primary">
									<div class="panel-body">
										<table class="table">
											<tr>
												<td>时间范围:</td>
												<td><input type="radio" name="_time_range" id="_time_range"  value="1"/>天</td>
												<td><input type="radio" name="_time_range" id="_time_range" value="2"/>月</td>
												<td><input type="radio" name="_time_range" id="_time_range" value="3"/>所有</td>
											</tr>
											<tr>
												<td colspan="4" style="text-align: right">
													<button type="button" class="btn btn-primary" onclick="javascript:queryUserRegs();">查询</button>
												</td>
											</tr>
										</table>
									</div>
								</div>
							</td>
						</tr>
						<!-- <tr>
							<td colspan="3">
								<button id="paySubmitId" type="button" class="btn btn-info" onclick="javascript:exprotExcel();">导出</button>
							</td>
						</tr> -->
						<tr>
							<td>日期</td>
							<td>注册数</td>
						</tr>
					</thead>
					<tbody id="bodyid">
			    	</tbody>
					<tfoot>
						 <tr>
							<td colspan="3" style="text-align: right">
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
</body>
</html>
