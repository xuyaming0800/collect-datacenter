<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
  	function list(page) {
  		if(undefined == page){
  			page = 1;
  		}
  		$.post("<%=request.getContextPath()%>/report/report_city_user_regs/query.html",
  			{'page':page
			},
			function(data){
				var containerBody = $("#bodyid").empty();
				var htm = "";
				data = $.parseJSON(data);
				var list=data.list;
				if(list != null && list.length > 0) {
					$.each(list,function(i,n){
					    htm +=  '<tr>'
		    			+ '<td>' + n.city + '</td>'
		    			+ '<td>' + n.total + '</td>'
		    			+ '</tr>';
					});
					containerBody.html(htm);
				}else {
					containerBody.html("<tr><td colspan='3'>未查询到数据<td></tr>");
				}
		});
  	}
  	$(function(){
  		queryUserCity();
    });
  	function queryUserCity() {
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
			url: "<%=request.getContextPath()%>/report/report_city_user_regs/query.html?page=1",
			dataType: "json",
			success: function(data){
				if(data.pageCount){
					options.totalPages=data.pageCount%10==0?(data.pageCount/10):(data.pageCount/10+1);
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
				<h3 class="panel-title">用户分布</h3>
			</div>
			<div class="panel-body">
				<table class="table table-striped">
					<thead>
						<!-- <tr>
							<td colspan="5">
								<button id="paySubmitId" type="button" class="btn btn-info" onclick="javascript:exprotExcel();">导出</button>
							</td>
						</tr> -->
						<tr>
							<td>区域</td>
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
