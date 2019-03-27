package com.delta.soft_manage_system.controller;

import com.delta.soft_manage_system.dto.TweiApiType;
import com.delta.soft_manage_system.service.ApiTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname ApiTypeController
 * @Date 2019/3/27 08:40
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@Controller
@RequestMapping("/admin/apitype")
public class ApiTypeController extends BaseController<ApiTypeService, TweiApiType> {
    @Autowired
    public ApiTypeController(ApiTypeService apiTypeService){
        super(apiTypeService);
    }
}
