package com.delta.soft_manage_system.controller;

import com.delta.soft_manage_system.dto.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @ApiOperation(value="测试获取用户信息",notes = "测试获取用户信息,并打印用户信息")
    @GetMapping("test")
    @ResponseBody
    public String test(){
        try {
            String string = jdbcTemplate.queryForObject("select user_name from twei_user where userid = 'weilizong'", String.class);
            User user = new User();
            user.setUserid(string);
            return user.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "get connection failed";
    }
}
