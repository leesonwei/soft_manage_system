package com.delta.soft_manage_system.controller;

import com.alibaba.fastjson.JSON;
import com.delta.soft_manage_system.dto.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/admin/test")
public class TestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @ApiOperation(value="测试获取用户信息",notes = "测试获取用户信息,并打印用户信息")
    @GetMapping("/user/count")
    @ResponseBody
    public String test(){
        try {
            Map<String, Object> map = jdbcTemplate.queryForMap("select * from twei_user where userid = 'weilizong'");
            User user = new User();
            user.setUserid((String)map.get("userid"));
            user.setUserName((String)map.get("user_name"));
            user.setPassword((String)map.get("password"));
            return JSON.toJSONString(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "get connection failed";
    }
}
