package com.delta.soft_manage_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname IndexController
 * @Description
 * @Date 2019/3/21 13:55
 * @Author LIZONG.WEI
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "front/index";
    }
}
