
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html><!--Bootstrap ?????? HTML ??? CSS ?????????? HTML5 ????-->
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- ??3?meta??*??*?????????????*??*????? -->
  <title>Document</title>
  
  <link rel="stylesheet" href="<%=basePath %>resources/css/bootstrap/bootstrap.css">
</head>
<body>
	<a href="http://localhost:8080/watermeter/role/getRole.do?id=7"></a>
  <!--bootstrap????jQuery????????????jQuery-->
  <script src="<%=basePath %>resources/js/bootstrap/jquery-1.11.3.min.js"></script>
  <script src="<%=basePath %>resources/js/bootstrap/bootstrap.js"></script>
</body>
</html>
