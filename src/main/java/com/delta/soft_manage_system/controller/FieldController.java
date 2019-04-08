package com.delta.soft_manage_system.controller;

import com.delta.common.utils.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Classname FieldController
 * @Date 2019/3/28 09:54
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@RestController
@RequestMapping("/field")
@Slf4j
public class FieldController {

    @RequestMapping("/getField")
    public ServerResponse<List<String>> getField(String className){
        List<String> fields = null;

        return ServerResponse.createBySuccess(fields);
    }
}
