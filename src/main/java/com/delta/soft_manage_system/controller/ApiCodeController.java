package com.delta.soft_manage_system.controller;

import com.delta.soft_manage_system.dto.TweiApiCode;
import com.delta.soft_manage_system.service.ApiCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname ApiCodeController
 * @Date 2019/3/27 08:33
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@Controller
@RequestMapping("/admin/apicode")
public class ApiCodeController extends BaseController<ApiCodeService, TweiApiCode> {
    @Autowired
    public ApiCodeController(ApiCodeService apiCodeService){
        super(apiCodeService);
    }
}
