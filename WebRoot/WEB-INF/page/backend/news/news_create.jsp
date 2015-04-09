<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台添加新闻</title>
<link href="<%=path%>/resources/css/login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path %>/resources/js/common/mf.jquery.js"></script>
<script type="text/javascript"></script>
</head>
  
<body>
	<center>
		<form action="" id="form" name="myForm" method="post">
			<table>
				<tr>
					<td><span id="msg"></span></td>
				</tr>
				<tr>
					<td>标题：</td>
					<td><input id="username" type="text" name="title"/></td>
				</tr>
				<tr>
					<td>创建人：</td>
					<td><input id="nickname" type="text" name="creator" value="皮卡丘" readonly="readonly"/></td>
				</tr>
				<tr>
					<td>类型：</td>
					<td>
						<input type="radio" name="type" value="0"/>系统公告
						<input type="radio" name="type" value="1"/>个人心得
					</td>
				</tr>
				<tr>
					<td>内容：</td>
					<td>
						<textarea rows="10" cols="50" name="content"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input id="register" type="submit" value="注册"/>
					</td>
				</tr>
		 </table>
		</form>
	</center>
  </body>
</html>
