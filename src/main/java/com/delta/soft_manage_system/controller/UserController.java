package com.delta.soft_manage_system.controller;

import com.alibaba.fastjson.JSON;
import com.delta.soft_manage_system.common.ServerResponse;
import com.delta.soft_manage_system.dto.User;
import com.delta.soft_manage_system.service.UserService;
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

    @GetMapping("/login")
    public String getLoginFile(){
        return "backend/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ServerResponse<User> login(User user){
        ServerResponse<User> serverResponse = userService.login(user);
        // TODO: 2019/3/21 簽發jwt 
        return serverResponse;
    }

    @PostMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.setMaxInactiveInterval(-1);
        // TODO: 2019/3/21 作廢jwt
        return "backend/login";
    }
}
