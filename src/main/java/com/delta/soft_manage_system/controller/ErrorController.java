package com.delta.soft_manage_system.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Classname ErrorController
 * @Date 2019/3/25 10:47
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@Controller
@Slf4j
public class ErrorController {

    @RequestMapping("/error/500")
    public String e500(){
        return "/error/500";
    }

    @RequestMapping("/error/403")
    public String e403(HttpServletRequest request){
        Object res = request.getSession().getAttribute("res");
        log.info(JSON.toJSONString(res));
        return "/error/403";
    }
}
