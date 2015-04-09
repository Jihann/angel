<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/tags/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>index</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="<%=path %>/resources/js/common/mf.jquery.js"></script>
<script type="text/javascript">
	function _del(id, obj){
		var _this = obj
		var url = "<%=path%>/back/users/" + id + "/person";
		jQuery.ajax({
			type : "DELETE",
			url : url,
			cache : false,
			dataType : "text",
			success : function(data){
				alert(data);
				if(data === "success"){
			         jQuery(_this).parent("td").parent("tr").remove();//移除当前行
				}
				//行号重新排序
				var len = jQuery("#tab tr").length;
	            for(var i = 0; i < len; i++){
	            	jQuery("#tab tr").eq(i + 1).children("td").eq(0).html(i + 1);
	            }
			},
			error : function(){
				alert("删除失败");
			}
		});
	}
	
	function _oper(id, state, obj){
		state = state === "1" ? "0" : "1";
		var url = "<%=path%>/back/users/" + id +  "/" + state + "/person";
		jQuery.ajax({
			type : "PUT",
			url : url,
			cache : false,
			dataType : "text",
			success : function(data){
				if(data === "success"){
					location.reload();
				}
			},
			error : function(){
				alert("禁用失败");
			}
		});
	}
</script>
  </head>
  
  <body>
    <center>Welcome back users manager</center>
    <center>
	    <form action="" method="post">
	    	<table id="tab">
	    		<tr>
	    			<td>序号</td>
	    			<td>员工编号</td>
	    			<td>员工账号</td>
	    			<td>状态</td>
	    			<td>注册时间</td>
	    			<td>最近登录</td>
	    			<td>操作</td>
	    		</tr>
	    		<c:forEach items="${userList }" var="user" varStatus="status">
	    		<tr>
	    			<td>${status.index + 1 }</td>
	    			<td>${user.userId }</td>
	    			<td>${user.userName }</td>
	    			<td>${user.lastLoginIp == '1' ? '启用' : '禁用' }</td>
	    			<td><fmt:formatDate value="${user.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	    			<td><fmt:formatDate value="${user.lastLoginTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	    			<td>
	    				<a href="javascript:void(0);"  onclick="_del('${user.userId}', this);">删除</a> |
	    				<a href="javascript:void(0);"  onclick="_oper('${user.userId}', '${user.lastLoginIp }', this);">${user.lastLoginIp == '1' ? '禁用' : '启用' }</a>
	    			</td>
	    		</tr>
	    		</c:forEach>
	    	</table>
	    </form>
    </center>
  </body>
</html>
