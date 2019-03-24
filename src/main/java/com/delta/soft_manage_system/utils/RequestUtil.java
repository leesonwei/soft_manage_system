/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RequestUtil
 * Author:   anywhere
 * Date:     3/24 0024 12:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.delta.soft_manage_system.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author anywhere
 * @create 3/24 0024
 * @since 1.0.0
 */
public class RequestUtil {

    public static String getToken(HttpServletRequest request){
        String token = request.getHeader("token");

        if (StringUtil.isBlank(token) && request.getCookies() != null) {
            List<Cookie> cookies = Arrays.asList(request.getCookies());
            for(Cookie cookie:cookies ){
                if ("token".equals(cookie.getName())) {
                    token = cookie.getValue();
                }
            }
        }
        if (StringUtil.isBlank(token)) {
            token = request.getParameter("token");
        }
        return token;
    }
}