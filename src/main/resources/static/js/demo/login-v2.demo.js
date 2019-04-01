/*
Template Name: Color Admin - Responsive Admin Dashboard Template build with Twitter Bootstrap 4
Version: 4.2.0
Author: Sean Ngu
Website: http://www.seantheme.com/color-admin-v4.2/admin/
*/

var handleLoginPageChangeBackground = function() {
	$(document).on('click', '[data-click="change-bg"]', function(e) {
		e.preventDefault();
		var targetImage = '[data-id="login-cover-image"]';
		var targetImageSrc = 'url(' + $(this).attr('data-img') +')';

		$(targetImage).css('background-image', targetImageSrc);
		$('[data-click="change-bg"]').closest('li').removeClass('active');
		$(this).closest('li').addClass('active');	
	});
};

var LoginV2 = function () {
	"use strict";
	return {
		//main function
		init: function () {
			handleLoginPageChangeBackground();
		},
		login: function () {
			var formData = $("#login").serializeJSON();
			$("#submit").text("正在登录...");
			$("#submit").attr("disabled", "disabled");
			$.ajax({
				url:'login',
				type:'post',
				data:formData,
				dataType:'json',
				success:function(json){
					Cookies.set('token', json.data);
					if (json.status === 0) {
						$("#submit").text("登入成功");
						window.location.href = "/admin/index?token=" + Cookies.get('token');
					} else {
						//layer.msg('錯誤代碼:' + json.status + ',' + json.msg);
						layer.open({
							title:'<strong><i class="fa fa-exclamation-circle text-danger"></i> ' + json.status + ' </strong>'
							,type:1
							,icon:0
							,offset: 'auto'
							,id: 'error' //防止重复弹出
							,content: '<div style="padding: 20px 100px;" class="text-danger">'+ json.msg +'</div>'
							,btn: '关闭'
							,btnAlign: 'r' //按钮居中
							,shade: 0 //不显示遮罩
							,yes: function(){
								layer.closeAll();
							}
							,time:2000
						});
						$("#submit").text("登入系统");
						$("#submit").removeAttr("disabled");
					}
				}
			});
		}
	};
}();