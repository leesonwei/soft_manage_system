package com.delta.soft_manage_system.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname IndexController
 * @Description
 * @Date 2019/3/21 13:55
 * @Author LIZONG.WEI
 */
@Controller
public class IndexController {

    @ApiOperation(value="首页",notes = "项目首页")
    @GetMapping("/index")
    public String index(){
        return "front/index";
    }
}
