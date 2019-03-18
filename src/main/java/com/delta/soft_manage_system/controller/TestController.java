package com.delta.soft_manage_system.controller;

import com.delta.soft_manage_system.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Controller
public class TestController {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("test")
    @ResponseBody
    public String test(){
        try {
            String string = jdbcTemplate.queryForObject("select userid from twei_user where userid = '1'", String.class);
            User user = new User();
            user.setUserid(string);
            return user.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "get connection failed";
    }
}
