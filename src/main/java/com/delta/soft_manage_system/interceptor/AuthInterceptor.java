package com.delta.soft_manage_system.interceptor;

import com.delta.auth.dto.TweiAuth;
import com.delta.common.constant.GlobalConst;
import com.delta.soft_manage_system.dto.ApplicationInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Classname AuthInterceptor
 * @Date 2019/4/12 17:29
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@Slf4j
@Component
@Order(2)
public class AuthInterceptor implements HandlerInterceptor {
    @Autowired
    private ApplicationInfo applicationInfo;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler)  throws Exception{
        String uri = request.getRequestURI();
        List<TweiAuth> auths = applicationInfo.getAuths();
        //權限為空,先登錄
        if (auths == null) {
            response.sendRedirect("/user/login");
        }
        //不在權限列表的url,不進行控制
        if (!checkAuth(uri,auths)) {
            return true;
        }
        //檢測所擁有的權限是否包含請求權限
        List<TweiAuth> oweAuths = (List<TweiAuth>)request.getSession().getAttribute(GlobalConst.AUTHS);
        if (checkAuth(uri,oweAuths)) {
            return true;
        } else {
            request.getRequestDispatcher("/error/403").forward(request,response);
        }
        return true;
    }

    private boolean checkAuth(String uri,List<TweiAuth> auths){
        boolean status = false;
        if (auths == null) {
            return status;
        }
        for (TweiAuth auth:auths) {
            if ("/".equals(auth.getAuthUrl()) || auth.getAuthUrl() == null) {
                continue;
            }
            if (uri.startsWith(auth.getAuthUrl())){
                status = true;
                break;
            }
        }
        return status;
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object object, Exception exception)
            throws Exception {

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object object, ModelAndView exception) throws Exception {

    }
}
