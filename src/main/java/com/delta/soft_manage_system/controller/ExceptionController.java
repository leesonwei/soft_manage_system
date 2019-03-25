package com.delta.soft_manage_system.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Classname ExceptionC
 * @Date 2019/3/25 10:45
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@ControllerAdvice
@Slf4j
public class ExceptionController {
    @ExceptionHandler(Exception.class)
    public String handler(Exception e){
        log.error("====================系統異常=================",e);
        return "redirect:/error/500";
    }
}
