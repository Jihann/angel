<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<link href="<%=path%>/resources/css/login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path %>/resources/js/common/mf.jquery.js"></script>
<script type="text/javascript" src="<%=path %>/resources/js/login.js"></script>
</head>
  
<body>
<input id="path" type="hidden" value="<%=path%>"/>
<div class="mainBox">
  <div class="regBox">
      <p class="title">登录</p>
      <div class="loginList">
        <div class="account">
            <span>会员账号：</span>
            <input id="username" type="text" name="userName" class="inputcontent"/>
        </div>
        <div class="password">
            <span>会员密码：</span>
            <input id="password" type="password" name="password" class="inputcontent" />
        </div>
          <div class="errorMessage"> </div>
          <div class="login">
              <span class="hidden">我要隐藏：</span>
              <input id="login" class="log"  type="button" value="立即登陆 " style="cursor: pointer;"/>
          </div>
          <div class="regCenter">
                <span class="hidden">我要隐藏：</span>
                 <span class="register"><a href="#"> 免费注册</a></span>
                 <span class="forget"><a href="#">忘记密码</a></span>
          </div>
      </div>
  </div>
</div>
  </body>
</html>
