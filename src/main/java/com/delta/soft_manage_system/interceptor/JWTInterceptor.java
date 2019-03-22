package com.delta.soft_manage_system.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.delta.soft_manage_system.common.JWTConstant;
import com.delta.soft_manage_system.common.ResponseCode;
import com.delta.soft_manage_system.common.ServerResponse;
import com.delta.soft_manage_system.common.TokenMgr;
import com.delta.soft_manage_system.dto.User;
import com.delta.soft_manage_system.utils.FastJsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import io.jsonwebtoken.Claims;


@Slf4j
public class JWTInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler)  throws Exception{
		response.setContentType("text/html;charset=UTF-8"); 
		//请求URL
		String url =request.getServletPath().toString();
				
		//如果是登录则不拦截开始
		if(url.contains("/login") || url.contains("/index")){
			return true;
		}
		String tokenStr = request.getParameter("token");
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
			PrintWriter printWriter = response.getWriter();
			printWriter.print(res);
			printWriter.flush();
			printWriter.close();
			return false;
		}
	}

}
