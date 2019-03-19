package com.delta.soft_manage_system.controller;

import com.delta.soft_manage_system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping("/count")
    @ResponseBody
    public int getUserCount(HttpSession session){
        ServletContext sc = session.getServletContext();
        log.info(sc.toString());
        return userService.getUserCount();
    }
}
