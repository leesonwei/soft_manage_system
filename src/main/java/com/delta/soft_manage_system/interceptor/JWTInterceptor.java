package com.delta.soft_manage_system.interceptor;

import com.alibaba.fastjson.JSON;
import com.delta.soft_manage_system.common.JWTConstant;
import com.delta.soft_manage_system.common.ResponseCode;
import com.delta.soft_manage_system.common.ServerResponse;
import com.delta.soft_manage_system.common.TokenMgr;
import com.delta.soft_manage_system.dto.User;
import com.delta.soft_manage_system.utils.FastJsonUtil;
import com.delta.soft_manage_system.utils.RequestUtil;
import com.delta.soft_manage_system.utils.StringUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Slf4j
@Component
public class JWTInterceptor implements HandlerInterceptor{

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

		if (tokenStr == null || tokenStr.equals("")) {
			ServerResponse<String> res = ServerResponse
					.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode()
							,"您尚未登錄");
			PrintWriter printWriter = response.getWriter();
			printWriter.print(JSON.toJSONString(res));
			printWriter.flush();
			printWriter.close();
			return false;
		}
		
		// 验证JWT的签名，返回CheckResult对象
		ServerResponse<Claims> checkResult = TokenMgr.validateJWT(tokenStr);
		if (checkResult.isSuccess()) {
			Claims claims = checkResult.getData();
			log.info("token校检通过checkResult："+ JSON.toJSONString(checkResult));
			User user = FastJsonUtil.toBean(claims.getSubject(), User.class);
			log.info("token校检通过user："+user.toString());
			Cookie cookie = new Cookie("token", tokenStr);
			response.addCookie(cookie);
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
			//response.sendRedirect("/error/403");
			PrintWriter printWriter = response.getWriter();
			printWriter.print(in);
			printWriter.flush();
			printWriter.close();
			return false;
		}
	}

}
