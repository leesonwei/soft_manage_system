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
					if (json.status === 0) {
						$("#submit").text("登入成功");
						window.location.href = "/admin/index";
					} else {
						swal(json.status+'',json.msg,"error");
						$("#submit").text("登入系统");
						$("#submit").removeAttr("disabled");
					}
				}
			});
		}
	};
}();