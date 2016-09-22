<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<!-- 可选的Bootstrap主题文件（一般不用引入） -->
	<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

	<script src="//cdn.bootcss.com/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.min.js"></script>

	<title>Document</title>
</head>
<body onload="today();">
	<div class="container" style=" width: 90% ">
	<div class="row clearfix">
		<div class="col-md-12 column">
		<h1 class="text-center">Header${a}</h1>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form class="form-horizontal" role="form" action="#">
				<div class="form-group">
					 <label for="assetName" class="col-sm-2 control-label">资产名称</label>
					<div class="col-sm-10 has-feedback">
						<input type="text" class="form-control" name="assetName" id="assetName" placeholder="名称"/>
						<a class="glyphicon glyphicon-remove btn form-control-feedback" style= "pointer-events: auto; color:black" id="clear" onclick="document.getElementById('assetName').value=null"></a>
					</div>
				</div>
				<div class="form-group has-feedback">
					 <label for="model" class="col-sm-2 control-label">类型</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="model" id="model" placeholder="类型" />
						<a class="glyphicon glyphicon-remove btn form-control-feedback" style= "pointer-events: auto; color:black" id="clear" onclick="document.getElementById('model').value=null"></a>
					</div>
				</div>
				<div class="form-group has-feedback">
					 <label for="specification" class="col-sm-2 control-label">型号</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="specification" id="specification" placeholder="型号" />
						<a class="glyphicon glyphicon-remove btn form-control-feedback" style= "pointer-events: auto; color:black" id="clear" onclick="document.getElementById('specification').value=null"></a>
					</div>
				</div>
				<div class="form-group ">
					 <label for="totalAsset" class="col-sm-2 control-label">价值</label>
					<div class="col-sm-10">
					<div class="input-group">
						 <div class="input-group-addon">￥</div>
						 <input type="text" class="form-control" id="totalAsset" name="totalAsset" placeholder="价值">
						 <a class="glyphicon glyphicon-remove btn form-control-feedback" style= "pointer-events: auto; color:black" id="clear" onclick="document.getElementById('totalAsset').value=null"></a>
						 </div>
					</div>
				</div>
				<div class="form-group has-feedback">
					 <label for="souresFounds" class="col-sm-2 control-label">来源</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="souresFounds" name="souresFounds" value="学院自筹">
						<a class="glyphicon glyphicon-remove btn form-control-feedback" style= "pointer-events: auto; color:black" id="clear" onclick="document.getElementById('souresFounds').value=null"></a>
					</div>
				</div>
				<div class="form-group">
					 <label for="dateOfAcquisition" class="col-sm-2 control-label">入库日期</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="dateOfAcquisition" id="dateOfAcquisition" />
						<script> 
							$(document).ready(function() { 
							$("#dateOfAcquisition").datepicker({
								minView: "month", //选择日期后，不会再跳转去选择时分秒 
								format: "yyyy-mm-dd", //选择日期后，文本框显示的日期格式 
								language: 'zh-CN', //汉化 
								autoclose:true //选择日期后自动关闭 
							}); 
							}); 
							function today(){
								var date = new Date();
								document.getElementById("dateOfAcquisition").value = 
								date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
							}
						</script>                	
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						 <button type="sublime" class="btn btn-default btn-block btn-success">录入</button>
					</div>
				</div>
			</form> 
		</div>
	</div>
</div>

</body>
</html>