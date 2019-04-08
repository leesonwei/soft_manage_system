package com.delta.soft_manage_system.controller;

import com.delta.auth.Service.UserService;
import com.delta.auth.dto.TweiUser;
import com.delta.common.constant.GlobalConst;
import com.delta.common.constant.JWTConstant;
import com.delta.common.utils.ServerResponse;
import com.delta.common.utils.TokenMgr;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Classname UserController
 * @Date 2019/3/19 14:13
 * @Author LIZONG.WEI
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value="获取登录页面",notes = "获取登录页面")
    @GetMapping("/login")
    public String getLoginFile(HttpServletRequest request){
        return "backend/login";
    }

    @ApiOperation(value="登入",notes = "登入系统")
    @PostMapping("/login")
    @ResponseBody
    public ServerResponse<String> login(TweiUser user, HttpSession session, HttpServletResponse response){
        ServerResponse<TweiUser> serverResponse = userService.login(user);
        ServerResponse<String> res = null;
        if (serverResponse.isSuccess()) {
            TweiUser successUser = serverResponse.getData();
            session.setAttribute(GlobalConst.CURRENT_USER,successUser);
            String token = TokenMgr.createJWT(successUser.getUserid(), JWTConstant.JWT_ISS,TokenMgr.generalSubject(user), JWTConstant.JWT_TTL);
            response.addHeader("token", token);
            Cookie cookie = new Cookie("token", token);
            response.addCookie(cookie);
            res = ServerResponse.createBySuccess(token);
        } else {
            res = ServerResponse.createByErrorCodeMessage(serverResponse.getStatus(),serverResponse.getMsg());
        }
        return res;
    }

    @ApiOperation(value="退出",notes = "退出登录")
    @GetMapping("/logout")
    public String logout(HttpSession httpSession, HttpServletRequest request, HttpServletResponse response){
        httpSession.setMaxInactiveInterval(1);
        request.changeSessionId();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("token".equals(cookie.getName())) {
                cookie.setMaxAge(-1);
            }
        }
        return "redirect:login";
    }
}
