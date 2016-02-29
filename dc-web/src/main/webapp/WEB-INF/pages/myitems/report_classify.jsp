<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<div class="container">
      <div class="list_main">
       <div class="tips">已采集任务总数<b> 200 </b>条，合格<b> 150 </b>条，不合格<b> 20 </b>条，审核中<b> 30 </b>条！</div>
          <h2 class="list_breadcrumb">当前位置：&nbsp;&nbsp;<a href="">测试项目模板</a>&nbsp;&nbsp;<span class="arial">〉</span>&nbsp;&nbsp;<a href="">广告监测</a>&nbsp;&nbsp;<span class="arial">〉</span>&nbsp;&nbsp;分类统计</h2>
	<div class="floatright"><span class="lefttext"  >选择统计类型</span><select class="select" name="select"><option>区域</option></select> <a class="btnsizi" href="">查找</a></div><h2 class="title14">区域统计表</h2>
    <div class="clear"></div> 
         <div class="list_table">
                <table>
                    <thead>
                        <tr>
                            <td>区域</td>
                            <td>采集开始时间</td>
                            <td>采集任务总数</td>
                            <td>累计支付费用</td>
                            <td>审核合格数</td>
                            <td>审核不合格数</td>
                            <td>审核中数</td>
                            <td>抽检数</td>
                            <td>明细</td>
                        </tr>
                    </thead>
                    <tbody id="tbody_content">
                        <tr >
                            <td>123456789</td>
							<td>123456789</td>
                            <td>123456789</td>
                            <td>5100.00</td>
                            <td>5100.00</td>
                            <td>510000</td>
                            <td>摩托罗拉1</td>
                             <td>摩托罗拉1</td>
                            <td><a href="#">查看</a></td>
                        </tr>
                        <tr class="odd">
                            <td>123456789</td>
							<td>123456789</td>
                            <td>123456789</td>
                            <td>5100.00</td>
                            <td>5100.00</td>
                            <td>510000</td>
                            <td>摩托罗拉1</td>
                            <td>摩托罗拉1</td>
                            <td><a href="#">查看</a></td>
                        </tr>
                        <tfoot>
                        <tr>
                            <td>总计</td>
							<td>1234567</td>
                            <td>123456</td>
                            <td>5100.00</td>
                            <td>5100.00</td>
                            <td>510000</td>
                            <td>1</td>
                            <td>摩托罗拉1</td>
                            <td></td>
                        </tr>
                        <tr>
						<td colspan="9" style="text-align: right">
								<div>
									<ul id="projectPage" class="pagination pagination-sm">
									</ul>
								</div> 
							</td>
						</tr>
                        </tfoot>
                    </tbody>
                </table>
				<!-- <div class="paginating">
			    	<div class="pageform"><a href="">确定</a><span>页</span><input type="text"><span>共50页 到第</span></div>
					<div class="pagepanel"><a href="#" class="down">下一页</a><a href="">5</a><a href="">4</a><a class="none">...</a><a href="">3</a><a href="">2</a><a href="" class="current">1</a><a href="#" class="up">上一页</a><span class="text">每页显示
						<select>
							<option>100</option>
						</select>条</span><span class="text">共 123 条记录</span>
					</div>
					<div class="clear"></div>
				</div> -->
            </div>
      </div>
      <div class="clear"></div>   
   </div> 
<script type="text/javascript">
$(function() {
	var pageNo = 1,pageSize=10;
	//查询
	query();
	function query(){
		$.post("<%=request.getContextPath()%>/myitems/report/queryClaStaList.html",{
			pageNo:pageNo,
			pageSize:pageSize
		},function(data) {
			if (data.success) {
				var containerBody = $("#tbody_content").empty();
				var htm = "";
				if(data.info.objectList != null && data.info.objectList.length > 0) {
					$.each(data.info.objectList,function(i,n){
						var tr = "";
						if(i%2==0){
							
						}
					    htm +=  "<tr>"
		    			+ "<td>" + n.area + "</td>"
		    			+ "<td>" + n.start_time + "</td>"
		    			+ "<td>" + n.system_type + "</td>"
		    			+ "<td>" + n.payamt + "</td>"
		    			+ "<td>" + n.sall + "</td>"
		    			+ "<td>" + n.auditing + "</td>"
		    			+ "<td>" + n.auditSuccess + "</td>"
		    			+ "<td>" + n.auditFall + "</td>"
		    			+ "<td><a href='#'>查看</a></td>"
		    			+ "</tr>";
					});
					containerBody.html(htm);
				}else {
					containerBody.html("<tr><td colspan='10'>未查询到数据<td></tr>");
				}
				options.onPageClicked=function(event, originalEvent, type, page){
					pageNo = page;
					query();
		        };
		        options.currentPage = pageNo;
				initPage(options,"projectPage",data.info.totalCount,data.info.limit);
			} else {
				var containerBody = $("#tbody_content").empty();
				containerBody.html("<tr><td colspan='10'>"+data.desc+"<td></tr>");
			}
		},"json");
	}
});
//分页参数
var options = {
    	size:"large",
        bootstrapMajorVersion:3,
        currentPage:1,
        numberOfPages:5,
        onPageClicked:function(event, originalEvent, type, page){
        	
        }
  }
function initPage(options,id,totalCount,limit) {
	//分页显示
	var pageElement = $("#"+id+"");
     options.totalPages=Math.floor(totalCount%limit==0?(totalCount/limit):(totalCount/limit+1));
    pageElement.bootstrapPaginator(options);
}
</script> 
</body>
</html>
