<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<span style="font-size:18px;"><!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
 
<title>某管理系统</title>
<link rel="stylesheet" href="<%=basePath %>resources/css/bootstrap/bootstrap.css">
<link rel="stylesheet" href="<%=basePath %>resources/css/myCss/login.css">
 
<style>
	body{
		margin-top: 65px;
	}
	.col-md-2{
		background-color: #ccc;
		/*?*/
		height: 600px;
	}
	#left-content{
		margin-top: 20px;
	}
	.list-group{
		padding-left: 0;
	}
	#panel-group{
		margin-top: 20px;
	}
	#onebtn{
		margin: 10px 0;
	}
	#btngroup button{
		width: 100%;
	}
	.progress{
		margin-top: 15px;
	}
 
</style>
 
</head>
 
<body>
<nav class="navbar navbar-default navbar-fixed-top navbar-inverse" role="navigation">
    <!--container-fluid表示自适应大小，container表示居中-->
	<div class="container">
		<!--定义顶部导航栏-->
		<div class="navbar-header">
			<!--button是当屏幕小于多少时出现的可以打开导航列表的按钮-->
			<button type="button" class="navbar-toggle collapsed" 
						data-toggle="collapse" data-target="#demo-navbar">
				<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">智能水表管理系统</a>
		</div>
		
		<!--collapse用于导航栏折叠之后数据在button按钮里点击显示-->
		<div class="collapse navbar-collapse" id="demo-navbar">
			<!--nav navbar-nav表示显示在导航栏里-->
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">首页</a></li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">功能<span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
						<!--通过dropdown-header来标记一组动作-->
							<li class="dropdown-header">信息</li>
							<li><a href="#">信息建立</a></li>
							<li><a href="#">信息查询</a></li>
							<li><a href="#">信息管理</a></li>
						</ul>
				</li>
				
				<li><a href="#" data-toggle="modal" data-target="#about">帮助</a></li>
                
			</ul>
			<form action="loginOut.do" method="post">
			<div class="pull-right">
				<a>管理员：${user.name}</a>
				<input class="btn btn-default" type="submit" value="退出"></input>
			</div>
			</form>
		</div>
	</div>
</nav>
 
<div class="container-fluid">
	<div class="row">
		<div class="col-md-2">
			<div class="text-center" id="left-content">
				<div class="list-group">
					<a href="#" class="list-group-item active">首页</a>
				</div>
				<div class="list-group">
					<a href="registerUser.do" class="list-group-item">添加管理员</a>
					<a href="manageCommunity.do" class="list-group-item">负责社区</a>
					<a href="#" class="list-group-item">信息管理</a>
					<a href="#" class="list-group-item">信息建立</a>
				</div>
				<div class="list-group">
					<a href="#" class="list-group-item">设置</a>
					<a href="#" class="list-group-item">帮助</a>
				</div>
			</div>
		</div>
 
		<div class="col-md-10">
			<h2>管理控制台</h2>
			<hr class="divider">
			
  			<button type="button" class="btn btn-default">操作一</button>
  			<button type="button" class="btn btn-primary">操作二</button>
  			<button type="button" class="btn btn-success">操作三</button>
  			<button type="button" class="btn btn-info">操作四</button>
  			<button type="button" class="btn btn-warning">操作五</button>
  			<button type="button" class="btn btn-danger">操作六</button>
 
  			<div id="panel-group">
 
  				<!-- 1 -->
  				<div class="panel panel-primary">
  					<div class="panel-heading">
  						<h3 class="panel-title">最新提醒</h3>
  					</div>
  					<div class="panel-body">
  						<!-- <div class="alert alert-info" role="alert">
  							strong用于加粗文字
  							<strong>提示</strong> 您的订单(20160001)已经审批通过
  						</div>
  						<div class="alert alert-danger" role="alert">
  							<strong>提示</strong> 您的订单(20160002)被打回
  						</div>
  						<div class="alert alert-warning" role="alert">
  							<strong>提示</strong> 您的订单(20160003)付款延迟
  						</div> -->
  					</div>
  					
  				</div>
 
  				<!-- 2 -->
  				<div class="panel panel-primary">
  					<!-- <div class="panel-heading">
  						<h3 class="panel-title">我的任务</h3>
  					</div>
  					<div class="panel-body" id="btngroup">
  						<div><button class="btn btn-primary" type="button"><span class="pull-left">订单审批</span><span class="badge pull-right">42</span></button></div>
  						<div id="onebtn"><button class="btn btn-primary" type="button"><span class="pull-left">收款确认</span><span class="badge pull-right">20</span></button></div>
  						<div><button class="btn btn-primary" type="button"><span class="pull-left">付款确认</span><span class="badge pull-right">10</span></button></div>
  					</div> -->
  				</div>
 
  				<!-- 3 -->
  				<div class="panel panel-primary">
  					<!-- <div class="panel-heading">
  						<h3 class="panel-title">最新订单</h3>	
  					</div>
  					<div class="panel-body">
  						<table class="table">
  							<thead>
  								<tr>
  									<th>#</th>
  									<th>产品</th>
  									<th>数量</th>
  									<th>总金额</th>
  									<th>业务员</th>
  								</tr>
  							</thead>
  							<tbody>
  								<tr>
  									<th>1</th>
  									<th>Apple Macbook air</th>
  									<th>10</th>
  									<th>80000</th>
  									<th>张三</th>
  								</tr>
  								<tr>
  									<th>2</th>
  									<th>Apple iPad air</th>
  									<th>20</th>
  									<th>65000</th>
  									<th>李四</th>
  								</tr>
  								<tr>
  									<th>1</th>
  									<th>Apple Macbook pro</th>
  									<th>5</th>
  									<th>50000</th>
  									<th>王五</th>
  								</tr>
  							</tbody>
  						</table>
  					</div> -->
  				</div>
 
 
  				<!-- 4 -->
  				<div class="panel panel-primary">
  					<!-- <div class="panel-heading">
  						<h3 class="panel-title">工程进度</h3>
  					</div>
  					<div class="panel-body">
  						<button class="btn btn-primary" role="button">水井挖掘工程</button>
  							<div class="progress">
  								<div class="progress-bar progress-bar-info progress-bar-striped" role="progressbar" aria-valuenow=60 aria-valuemin=0 aria-valuemax=100 style="width: 60%">
  								<span class="sr only">完成60%</span>
  								</div>
  							</div>
  						<button class="btn btn-primary" role="button">基建工程</button>
  							<div class="progress">
  								<div class="progress-bar progress-bar-danger progress-bar-striped" role="progressbar" aria-valuenow=20 aria-valuemin=0 aria-valuemax=100 style="width: 20%">
  								<span class="sr only">完成20%</span>
  								</div>
  							</div>
  					</div> -->
  				</div>
 
  			</div>
 
			
		</div>
			
 
		</div>
		
	</div>
 
</div>
 
 
 
<script src="<%=basePath %>resources/js/bootstrap/jquery-1.11.3.min.js"></script>
<script src="<%=basePath %>resources/js/bootstrap/bootstrap.js"></script>
<script src="<%=basePath %>resources/js/myJs/login.js"></script>
</body>
</html></span>