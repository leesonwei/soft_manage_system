package com.delta.soft_manage_system.controller;

import com.alibaba.fastjson.JSON;
import com.delta.soft_manage_system.common.JWTConstant;
import com.delta.soft_manage_system.common.ServerResponse;
import com.delta.soft_manage_system.common.TokenMgr;
import com.delta.soft_manage_system.dto.User;
import com.delta.soft_manage_system.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/**
 * @Classname UserController
 * @Description TODO
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
    public ServerResponse<User> login(User user){
        ServerResponse<User> serverResponse = userService.login(user);
        User successUser = serverResponse.getData();
        TokenMgr.createJWT(successUser.getUserid(),JWTConstant.JWT_ISS,TokenMgr.generalSubject(user), JWTConstant.JWT_TTL);
        return serverResponse;
    }

    @ApiOperation(value="退出",notes = "退出登录")
    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.setMaxInactiveInterval(-1);
        // TODO: 2019/3/21 作廢jwt
        return "backend/login";
    }
}
