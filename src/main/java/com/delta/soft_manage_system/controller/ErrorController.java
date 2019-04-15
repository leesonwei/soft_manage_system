package com.delta.soft_manage_system.controller;

import com.alibaba.fastjson.JSON;
import com.delta.common.utils.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public String e500(HttpServletRequest request,HttpServletResponse response){
        response.setStatus(500);
        if (request.getHeader("X-Requested-With") != null) {
            return "redirect:/error/json";
        }
        return "/error/500";
    }

    @RequestMapping("/error/403")
    public String e403(HttpServletRequest request,HttpServletResponse response){
        response.setStatus(403);
        Object res = request.getSession().getAttribute("res");
        log.info(JSON.toJSONString(res));
        if (request.getHeader("X-Requested-With") != null) {
            return "redirect:/error/json";
        }
        return "/error/403";
    }
    @RequestMapping("/error/json")
    @ResponseBody
    public ServerResponse e403Json(HttpServletResponse response){
        String error = response.getStatus() == 500 ? "服務器異常" : response.getStatus() == 403 ? "您沒有操作權限" : "未知異常";
        return ServerResponse.createByErrorCodeMessage(response.getStatus(),error);
    }
}
