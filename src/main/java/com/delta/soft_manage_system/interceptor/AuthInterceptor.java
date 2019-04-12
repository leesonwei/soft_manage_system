package com.delta.soft_manage_system.interceptor;

import com.delta.auth.dto.TweiAuth;
import com.delta.common.constant.GlobalConst;
import com.delta.soft_manage_system.dto.ApplicationInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AuthInterceptor implements HandlerInterceptor {
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
        String uri = request.getRequestURI();
        List<TweiAuth> auths = applicationInfo.getAuths();
        if (!checkAuth(uri,auths)) {
            return true;
        }
        List<TweiAuth> oweAuths = (List<TweiAuth>)request.getSession().getAttribute(GlobalConst.AUTHS);
        if (checkAuth(uri,oweAuths)) {
            return true;
        } else {
            response.sendRedirect("/error/403");
        }
        return true;
    }

    private boolean checkAuth(String uri,List<TweiAuth> auths){
        boolean status = false;
        for (TweiAuth auth:auths) {
            if (uri.startsWith(auth.getAuthUrl())){
                status = true;
            }
        }
        return status;
    }
}
