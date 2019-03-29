package com.delta.soft_manage_system.controller;

import com.alibaba.fastjson.JSON;
import com.delta.soft_manage_system.common.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @Classname ExceptionC
 * @Date 2019/3/25 10:45
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@ControllerAdvice
@Slf4j
public class ExceptionController {
    @Autowired
    private HttpServletRequest request;

    @ExceptionHandler(Exception.class)
    public String handler(Exception e){
        log.error("====================系統異常=================",e);
        if (request.getHeader("X-Requested-With") != null) {
            return JSON.toJSONString(ServerResponse.createByErrorMessage("服務器出錯"));
        }
        return "redirect:/error/500";
    }
}
