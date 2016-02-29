<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<div class="container">
		<div class="list_main">
			<div class="tips">
				已采集任务总数<b> 200 </b>条，合格<b> 150 </b>条，不合格<b> 20 </b>条，审核中<b> 30 </b>条！
			</div>
			<h2 class="list_breadcrumb">
				当前位置：&nbsp;&nbsp;<a href="">测试项目模板</a>&nbsp;&nbsp;<span
					class="arial">〉</span>&nbsp;&nbsp;<a href="">广告监测</a>&nbsp;&nbsp;<span
					class="arial">〉</span>&nbsp;&nbsp;基本信息
			</h2>
			<div class="clear"></div>
			<form class="form-horizontal" role="form">
				<fieldset>
					<legend class="title14jiben">项目基本信息</legend>
					<div class="form-group jibeninput">
						<label class="col-sm-2 control-label" for="input01">创建时间</label>
						<div class="col-sm-3">
							<input class="form-control" type="text" placeholder="2015-12-12" />
						</div>
						<label class="col-sm-2 control-label" for="ds_name">创建人</label>
						<div class="col-sm-3">
							<input class="form-control" type="text" placeholder="lilifen" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="">创建状态</label>
						<div class="col-sm-3">
							<input class="form-control" type="text" placeholder="root" />
						</div>
						<label class="col-sm-2 control-label" for="ds_password">项目类型</label>
						<div class="col-sm-3">
							<input class="form-control" id="ds_password" type="password"
								placeholder="重要项目" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="">项目概述</label>
						<div class="col-sm-8">
							<textarea class="form-control" rows="6"
								placeholder="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laoreet. Proin gravida dolor sit amet lacus accumsan et viverra justo commodo. Proin sodales pulvinar tempor. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nam fermentum, nulla luctus pharetra vulputate, felis tellus mollis orci, sed rhoncus sapien nunc eget odio."></textarea>
						</div>
					</div>
					<div class="form-group" style="text-align:center">
						<p class="shenqingbtn" style="">
							<button>申请启动</button>
							<button>申请暂停</button>
						</p>
					</div>
				</fieldset>
			</form>
			<form class="form-horizontal" role="form">
				<fieldset>
					<legend class="title14jiben">费用信息</legend>
					<div class="form-group jibeninput">
						<label class="col-sm-2 control-label" for="input01">余额</label>
						<div class="col-sm-3">
							<input class="form-control" type="text" placeholder="2015-12-12" />
						</div>
						<label class="col-sm-2 control-label" for="ds_name">累计已支付</label>
						<div class="col-sm-3">
							<input class="form-control" type="text" placeholder="3456789" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="">余额阈值</label>
						<div class="col-sm-3">
							<input class="form-control" type="text" placeholder="root" />
						</div>
						<label class="col-sm-2 control-label" for="ds_password">垫付值</label>
						<div class="col-sm-3">
							<input class="form-control" id="ds_password" type="password"
								placeholder="1123" />
						</div>
					</div>
				</fieldset>
			</form>
		</div>
		<div class="clear"></div>
	</div>
	<script type="text/javascript">
	//TODO 项目管理和财务分别提供一个查询接口
	
	</script>
</body>
</html>
