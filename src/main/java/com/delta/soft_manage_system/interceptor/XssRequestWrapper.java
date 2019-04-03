package com.delta.soft_manage_system.interceptor;

import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @Classname XssRequestWrapper
 * @Date 2019/4/3 17:21
 * @Author LIZONG.WEI
 * @Since 1.8
 */
public class XssRequestWrapper extends HttpServletRequestWrapper {

    public XssRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String[] getParameterValues(String name) {
        //获取所有参数值的集合
        String[] results = this.getParameterMap().get(name);
        if (results != null && results.length > 0) {
            int length = results.length;
            for (int i = 0; i < length; i++) {
                //过滤参数值
                results[i] = HtmlUtils.htmlEscape(results[i]);
            }
            return results;
        }
        return null;
    }
}
