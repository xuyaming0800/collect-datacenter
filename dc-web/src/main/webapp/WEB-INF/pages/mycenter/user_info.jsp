<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<div class="container">
		<div class="list_main">
			<h2 class="list_breadcrumb">
				当前位置：&nbsp;&nbsp;<a href="">个人中心</a>&nbsp;&nbsp;<span class="arial">〉</span>&nbsp;&nbsp;<a
					href="">用户资料</a>
			</h2>
			<div class="clear"></div>
			<!--用户资料 start-->
			<form class="form-horizontal" role="form">
				<fieldset>
					<legend class="title14jiben">用户资料</legend>
					<div class="fleft col-sm-2">
						<div class="headimg">
							<img src="<%=request.getContextPath()%>/images/headimg.jpg"><a href="#"
								class="loadheadimg">设置公司logo</a>
						</div>
					</div>
					<div class="fleft col-sm-10">
						<div class="form-group jibeninput ">
							<label class="col-sm-2 control-label" for="input01"><i>*</i>公司名称</label>
							<div class="col-sm-3">
								<input class="form-control" type="text" disabled="disabled" placeholder="数字政通" id="company_name"/>
							</div>
							<label class="col-sm-2 control-label" for="ds_name">所在地</label>
							<div class="col-sm-3">
								<input class="form-control" type="text" disabled="disabled" placeholder="北京" id="city"/>
							</div>
						</div>
						<div class="form-group ">
							<label class="col-sm-2 control-label" for=""><i>*</i>联系人</label>
							<div class="col-sm-3">
								<input class="form-control" type="text" disabled="disabled" placeholder="王五" id="contacts_name"/>
							</div>
							<label class="col-sm-2 control-label" for="ds_password"><i>*</i>手机</label>
							<div class="col-sm-3">
								<input class="form-control" id="ds_password" type="text" disabled="disabled"
									placeholder="15056581633" id=mobile_phone/>
							</div>
						</div>
						<div class="form-group ">
							<label class="col-sm-2 control-label" for=""><i>*</i>座机电话</label>
							<div class="col-sm-3">
								<input class="form-control" type="text" disabled="disabled" placeholder="010-58886666" id="telphone"/>
							</div>
							<label class="col-sm-2 control-label" for="ds_password"><i>*</i>传真</label>
							<div class="col-sm-3">
								<input class="form-control" id="ds_password" disabled="disabled" type="text"
									placeholder="1015555555" id="fax"/>
							</div>
						</div>
						<div class="form-group ">
							<label class="col-sm-2 control-label" for=""><i>*</i>邮编</label>
							<div class="col-sm-3">
								<input class="form-control" type="text" disabled="disabled" placeholder="100000" id="zip_code"/>
							</div>
							<label class="col-sm-2 control-label" for="ds_password"><i>*</i>地址</label>
							<div class="col-sm-3">
								<input class="form-control" id="ds_password" disabled="disabled" type="text"
									placeholder="北京海淀区东北旺西路软件园大厦9号楼一区303室" id="address"/>
							</div>
						</div>
						<div class="form-group"
							style="text-align:center; margin-top:60px;">
							<p class="shenqingbtn" style="">
								<button id="update_btn" type="button">修改</button>
								<button id="save_btn" type="button">保存</button>
							</p>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
		<div class="clear"></div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			
			var updateFlag = false;
			$("#update_btn").bind("click", function(){
				$("input[type='text']").removeAttr("disabled");
			});
			var input = $("input[type='text']");
			$.each(input,function(i,n) {
				$(n).bind("change",function(){
					updateFlag = true;
				});
			});
			$("#save_btn").bind("click", function(){
				if(updateFlag){
					$("#company_name").val();
					$("#city").val();
					$("#contacts_name").val();
					$("#fax").val();
					$("#zip_code").val();
					$("#address").val();
					$("#mobile_phone").val();
					$("#telphone").val();
					alert("修改了");
				}
				$("input[type='text']").attr("disabled","true");
				updateFlag = false;
			});
		});
	</script>
</body>
</html>
