package com.delta.soft_manage_system.controller;

import com.delta.soft_manage_system.dto.TweiApi;
import com.delta.soft_manage_system.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname ApiController
 * @Date 2019/3/27 08:39
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@Controller
@RequestMapping("/admin/api")
public class ApiController extends BaseController<ApiService, TweiApi> {
    @Autowired
    public ApiController(ApiService apiService){
        super(apiService);
    }
}
