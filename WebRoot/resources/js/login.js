/**
 * create 2015-02-06 by jbh
 */
;(function(){
	jQuery(function(){
		
		var $path = jQuery("#path").val();
		jQuery("#login").on("click", function(){
			if(!jQuery("#username").val()){
				alert("用户名不能为空");
				return false;
			}else if(!jQuery("#password").val()){
				alert("密码不能为空");
				return false;
			}else{
				var $username = jQuery("#username").val();
				var $password = jQuery("#password").val();
				var params = {username:$username,password:$password};
				var url = $path + "/index/login";
				jQuery.ajax({
					type:"POST",
					url:url,
					data:params,
					async:false,
					dataType:"text",
					success:function(data){
						if(data === "1"){
							alert("你输入的用户不存在，请先注册");
						}else if(data === "2"){
							alert("你输入的密码有误，请重新输入");
						}else if(data === "0"){
							window.location.href = $path + "/index";
						}else{
							window.location.href = $path + "/back/index";
						}
					},
					error:function(){
						alert("登陆失败");
					}
				});
			}
		});
	});
})();

