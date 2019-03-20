package com.delta.soft_manage_system.interceptor;

import com.delta.soft_manage_system.common.ApplicationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Classname GlobalInterceptor
 * @Description
 * @Date 2019/3/19 16:58
 * @Author LIZONG.WEI
 */
@Component
public class GlobalInterceptor implements HandlerInterceptor {
    @Autowired
    private ApplicationInfo applicationInfo;
    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        ServletContext sc = httpServletRequest.getServletContext();
        if (sc.getAttribute("appname") == null) {
            sc.setAttribute("appname", applicationInfo.getName());
            sc.setAttribute("version", applicationInfo.getVersion());
            sc.setAttribute("company", applicationInfo.getCompany());
        }
        return true;
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}
