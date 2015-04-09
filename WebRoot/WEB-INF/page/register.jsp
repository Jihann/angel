<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册</title>
<link href="<%=path%>/resources/css/login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path %>/resources/js/common/mf.jquery.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function(){
		_check = function(){
			if(!jQuery("#username").val()){
				alert("会员账号不能为空");
				return false;
			}else if(!jQuery("#nickname").val()){
				alert("会员昵称不能为空");
				return false;
			}else if(!jQuery("#password").val()){
				alert("登录密码不能为空");
				return false;
			}else if(!jQuery("#confirmPwd").val()){
				alert("确认密码不能为空");
				return false;
			}else if(jQuery("#password").val() !== jQuery("#confirmPwd").val()){
				alert("登录密码和确认密码不一致");
				return false;
			}else if(!jQuery("#email").val()){
				alert("邮箱不能为空");
				return false;
			}else{
				var $username = jQuery("#username").val();
				var url = "<%=path%>/index/valid";
				var params = {username:$username};
				jQuery.post(url, params, function(data){
					if(data === "true"){
						jQuery("#msg").html("<font color=red>用户名已注册</font>");
						return false;
					}else{
						jQuery("#msg").html("<font color=green>该用户名可以使用</font>");
						var url = "<%=path%>/index/register";
						var params = jQuery("form[name=myForm]").serialize();
						jQuery.ajax({
							type:"POST",
							url:url,
							data:params,
							async:false,
							dataType:"text",
							success:function(data){
								if(data === "true"){
									window.location.href = "<%=path%>/index";
								}else{
									jQuery("#msg").html("<font color=red>用户注册失败</font>");
								}
							},
							error:function(){
								jQuery("#msg").html("<font color=red>用户注册失败</font>");
							}
						});
					}
				});
			}
		}
	});
</script>
</head>
  
<body>
	<center>
		<form action="" id="form" name="myForm" method="post">
			<table>
				<tr>
					<td><span id="msg"></span></td>
				</tr>
				<tr>
					<td>会员账号：</td>
					<td><input id="username" type="text" name="userName"/></td>
				</tr>
				<tr>
					<td>会员昵称：</td>
					<td><input id="nickname" type="text" name=""/></td>
				</tr>
				<tr>
					<td>登录密码：</td>
					<td><input id="password" type="password" name="password"/></td>
				</tr>
				<tr>
					<td>确认密码：</td>
					<td><input id="confirmPwd" type="password" name=""/></td>
				</tr>
				<tr>
					<td>电子邮箱：</td>
					<td><input id="email" type="text" name=""/></td>
				</tr>
				<tr>
					<td colspan="2">
						<input id="register" type="button" value="注册" onclick="_check();"/>
					</td>
				</tr>
		 </table>
		</form>
	</center>
  </body>
</html>
