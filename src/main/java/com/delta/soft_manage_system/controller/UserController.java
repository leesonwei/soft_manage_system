package com.delta.soft_manage_system.controller;

import com.delta.soft_manage_system.common.GlobalConst;
import com.delta.soft_manage_system.common.JWTConstant;
import com.delta.soft_manage_system.common.ServerResponse;
import com.delta.soft_manage_system.common.TokenMgr;
import com.delta.soft_manage_system.dto.User;
import com.delta.soft_manage_system.service.UserService;
import com.delta.soft_manage_system.utils.RequestUtil;
import com.delta.soft_manage_system.utils.StringUtil;
import com.sun.deploy.net.HttpResponse;
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
import java.util.Arrays;
import java.util.List;

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
    public String getLoginFile(){
        return "backend/login";
    }

    @ApiOperation(value="登入",notes = "登入系统")
    @PostMapping("/login")
    @ResponseBody
    public ServerResponse<User> login(User user, HttpSession session, HttpServletResponse response){
        ServerResponse<User> serverResponse = userService.login(user);
        if (serverResponse.isSuccess()) {
            //generat jwt
            User successUser = serverResponse.getData();
            session.setAttribute(GlobalConst.CURRENT_USER,successUser);
            String token = TokenMgr.createJWT(successUser.getUserid(),JWTConstant.JWT_ISS,TokenMgr.generalSubject(user), JWTConstant.JWT_TTL);
            response.addHeader("token", token);
            Cookie cookie = new Cookie("token", token);
            response.addCookie(cookie);
        }
        return serverResponse;
    }

    @ApiOperation(value="退出",notes = "退出登录")
    @GetMapping("/logout")
    public String logout(HttpSession httpSession, HttpServletRequest request, HttpServletResponse response){
        httpSession.setMaxInactiveInterval(-1);
        String token = RequestUtil.getToken(request);
        TokenMgr.expiredJWT(token);
        response.addHeader("token", "");
        Cookie cookie = new Cookie("token", "");
        response.addCookie(cookie);
        return "redirect:login";
    }
}
