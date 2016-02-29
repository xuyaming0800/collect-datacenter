<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
  	function list(page) {
  		username = $("#usernameId").val();
  		if(undefined == username) {
  			username =null;
  		}
  		if(undefined == page){
  			page = 1;
  		}
  		$.post("<%=request.getContextPath()%>/report/report_where_user_regs/query.html",
  			{'page':page,
  			'username':username
			},
			function(data){
				var containerBody = $("#bodyid").empty();
				var htm = "";
				data = $.parseJSON(data);
				var list=data.list;
				if(list != null && list.length > 0) {
					$.each(list,function(i,n){
						/* var cityByTel;
						 $.ajax({
								url: "http://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel="+n.mobile,
								dataType: "jsonp",
								success: function(dataBytel){
									if(dataBytel.province){
										$("#cityByTel"+i).text(dataBytel.province);
									}
									
								}
						}); */
						var _age=n.age;
						if(_age==0){
							_age="无";
						}
					    htm +=  '<tr>'
		    			+ '<td>' + n.name + '</td>'
		    			+ '<td>' + n.truename + '</td>'
		    			+ '<td>' + n.mobile + '</td>'
		    			+ '<td>' + n.city + '</td>'
		    			+ '<td>' + _age + '</td>'
		    			+ '<td>' + n.verifyIdCardName + '</td>'
		    			+ '<td>' + n.withdrawAccount + '</td>'
// 		    			+"<td id=cityByTel"+i+">"+ '</td>'
		    			+ '</tr>';
					   
					});
					containerBody.html(htm);
				}else {
					containerBody.html("<tr><td colspan='8'>未查询到数据<td></tr>");
				}
		});
  	}
	$(function(){
		queryUserInfo();
    });
  	function queryUserInfo() {
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
			url: "<%=request.getContextPath()%>/report/report_where_user_regs/query.html?page=1&username="+username,
			dataType: "json",
			success: function(data){
				if(data.pageCount){
					 options.totalPages=data.pageCount;
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
				<h3 class="panel-title">用户信息</h3>
			</div>
			<div class="panel-body">
				<table class="table table-striped">
					<thead>
						<tr>
							<td colspan="8">
								<div class="panel panel-primary">
									<div class="panel-body">
										<table class="table">
											<tr>
												<td>用户名:</td>
												<td><input id="usernameId" type="text" name="username" placeholder="用户名"></td>
											</tr>
											<tr>
												<td colspan="9" style="text-align: right">
													<button type="button" class="btn btn-primary" onclick="javascript:queryUserInfo();">查询</button>
												</td>
											</tr>
										</table>
									</div>
								</div>
							</td>
						</tr>
						<!-- <tr>
							<td colspan="8">
								<button id="paySubmitId" type="button" class="btn btn-info" onclick="javascript:exprotExcel();">导出</button>
							</td>
						</tr> -->
						<tr>
							<td>名称</td>
							<td>昵称</td>
							<td>手机号</td>
							<td>区域</td>
							<td>年龄</td>
							<td>实名认证</td>
							<td>提现金额</td>
						</tr>
					</thead>
					<tbody id="bodyid">
			    	</tbody>
					<tfoot>
						<tr>
							<td colspan="8" style="text-align: right">
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
