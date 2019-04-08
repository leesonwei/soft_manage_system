package com.delta.soft_manage_system.utils;

import com.delta.common.constant.GlobalConst;
import com.delta.common.utils.StringUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Classname RequestUtil
 * @Date 2019/4/8 14:35
 * @Author LIZONG.WEI
 * @Since 1.8
 */
public class RequestUtil {
    public static String getToken(HttpServletRequest request){
        String token = null;
        token = request.getHeader("token");
        if (!StringUtil.isBlank(token)) {
            return token;
        }
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies) {
            if(GlobalConst.TOKEN.equalsIgnoreCase(cookie.getName())){
                token = cookie.getValue();
                break;
            }
        }
        if (!StringUtil.isBlank(token)) {
            return token;
        }
        token = request.getParameter("token");
        if (!StringUtil.isBlank(token)) {
            return token;
        }
        return token;
    }
}
