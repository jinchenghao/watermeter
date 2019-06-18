
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html><!--Bootstrap 使用到的某些 HTML 元素和 CSS 属性需要将页面设置为 HTML5 文档类型-->
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
  <title>login</title>
  
  <link rel="stylesheet" href="<%=basePath %>resources/css/bootstrap/bootstrap.css">
  <link rel="stylesheet" href="<%=basePath %>resources/css/myCss/login.css">
</head>
<body>
<!-- 引入头部JSP -->
 <%-- <jsp:include page="head.jsp"></jsp:include> --%>
 <!-- 使用模态框的方式模拟一个登录框 -->
 <div class="modal show" id="loginModal">
    <div class="modal-dialog">
      <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close">×</button>
              <h1 class="text-center text-primary">登录</h1>
            </div>
            <div class="modal-body">
            <form class="form col-md-12 center-block" id="loginForm" action="main/successLogin.do" method="post">
            <div class="form-group-lg"  id="accountDiv">
              <label class="sr-only" for="inputAccount">账号</label>
              <div class="input-group">
                <div class="input-group-addon"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></div>
                <input class="form-control" id="inputAccount" name="accountNo" type="text" placeholder="账号" required autofocus>
              </div>
              <div class="hidden text-center" id="accountMsg"><span class="glyphicon glyphicon-exclamation-sign"></span>用户名不存在</div>
            </div>
            <br>
            <div class="form-group-lg" id="pwdDiv">
              <label class="sr-only" for="inputPassword">密码</label>
              <div class="input-group">
                <div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>
                <input class="form-control" id="inputPassword" name="pwd" type="password" placeholder="密码" required>
                <div class="input-group-addon"><span class="glyphicon glyphicon-eye-open"></span></div>
              </div>
              <div class="hidden text-center" id="pwdMsg"><span class="glyphicon glyphicon-exclamation-sign"></span>用户名密码错误</div>
            </div>
            <div class="checkbox">
              <label> <input type="checkbox" value="remember-me">记住我</label>
            </div>
            <div class="form-group">
              <button class="btn btn-default btn-lg col-md-6" id="btn_register" type="submit">注册</button>
              <button class="btn btn-primary btn-lg col-md-6" id="btn_login" type="button" >登录</button>
            </div>
          </form>
        </div>
        <div class="modal-footer">
        
        </div>
      </div>
    </div>
  </div>

  <!--bootstrap需要依赖jQuery，所以必须在他之前先引入jQuery-->
  <script src="<%=basePath %>resources/js/bootstrap/jquery-1.11.3.min.js"></script>
  <script src="<%=basePath %>resources/js/bootstrap/bootstrap.js"></script>
  <script src="<%=basePath %>resources/js/myJs/login.js"></script>
</body>
</html>
