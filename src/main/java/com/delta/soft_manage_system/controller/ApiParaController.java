package com.delta.soft_manage_system.controller;

import com.delta.soft_manage_system.dto.TweiApiPara;
import com.delta.soft_manage_system.service.ApiParaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname ApiParaController
 * @Date 2019/3/27 08:38
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@Controller
@RequestMapping("/admin/apipara")
public class ApiParaController extends BaseController<ApiParaService, TweiApiPara> {
    @Autowired
    public ApiParaController(ApiParaService apiParaService){
        super(apiParaService);
    }
}
