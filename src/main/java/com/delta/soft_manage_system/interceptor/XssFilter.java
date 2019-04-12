package com.delta.soft_manage_system.interceptor;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Classname XssFilter
 * @Date 2019/4/3 17:19
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@Component
@WebFilter(urlPatterns = "/*", filterName = "xssFilter")
public class XssFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (request.getRequestURI().contains("json")) {
            filterChain.doFilter(request, servletResponse);
        } else {
            filterChain.doFilter(new XssRequestWrapper(request), servletResponse);
        }
    }
}
