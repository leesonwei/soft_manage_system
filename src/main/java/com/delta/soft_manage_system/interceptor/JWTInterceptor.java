package com.delta.soft_manage_system.interceptor;

import com.alibaba.fastjson.JSON;
import com.delta.soft_manage_system.common.*;
import com.delta.soft_manage_system.dto.User;
import com.delta.soft_manage_system.utils.FastJsonUtil;
import com.delta.soft_manage_system.utils.RequestUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;


@Slf4j
@Component
public class JWTInterceptor implements HandlerInterceptor{

	@Autowired
	private ApplicationInfo applicationInfo;

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception exception)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object object, ModelAndView exception) throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler)  throws Exception{
		response.setContentType("text/html;charset=UTF-8");

		String tokenStr = RequestUtil.getToken(request);

		if (applicationInfo.getDebug()) {
			//debug模式不驗證jwt
			User user = new User();
			user.setUserid("weilizong");
			user.setUserName("韋利總");
			request.getSession().setAttribute(GlobalConst.CURRENT_USER, user);
			return true;
		}

		if (tokenStr == null || tokenStr.equals("")) {
			ServerResponse<String> res = ServerResponse
					.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode()
							,"您尚未登錄");
			response.sendRedirect("/user/login");
			return false;
		}
		
		// 验证JWT的签名，返回CheckResult对象
		ServerResponse<Claims> checkResult = TokenMgr.validateJWT(tokenStr);
		if (checkResult.isSuccess()) {
			Claims claims = checkResult.getData();
			log.info("token校检通过checkResult："+ JSON.toJSONString(checkResult));
			User user = FastJsonUtil.toBean(claims.getSubject(), User.class);
			//request.getSession().setAttribute(GlobalConst.CURRENT_USER, user);
			log.info("token校检通过user："+user.toString());
			return true;
		} else {
			ServerResponse<String> res = ServerResponse
					.createByErrorCodeMessage(JWTConstant.JWT_ERRCODE_EXPIRE
							,"沒有權限");
			switch(checkResult.getStatus()) {
				// 签名过期，返回过期提示码
				case JWTConstant.JWT_ERRCODE_EXPIRE:
					res = ServerResponse
							.createByErrorCodeMessage(JWTConstant.JWT_ERRCODE_EXPIRE
									,"token 過期");
					break;
				// 签名验证不通过
				case JWTConstant.JWT_ERRCODE_FAIL:
					res = ServerResponse
							.createByErrorCodeMessage(JWTConstant.JWT_ERRCODE_EXPIRE
									,"沒有權限");
					break;
				default:
					break;
			}
			response.setStatus(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED.value());
			Resource resource =new ClassPathResource("templates/error/403.html");
			InputStream in = resource.getInputStream();
			request.getSession().setAttribute("res", res);
			response.sendRedirect("/error/403");
			return false;
		}
	}

}
