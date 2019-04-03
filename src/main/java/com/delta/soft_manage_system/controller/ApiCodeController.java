package com.delta.soft_manage_system.controller;

import com.delta.soft_manage_system.common.ServerResponse;
import com.delta.soft_manage_system.dto.TweiApi;
import com.delta.soft_manage_system.dto.TweiApiCode;
import com.delta.soft_manage_system.service.ApiCodeService;
import com.delta.soft_manage_system.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    private ApiService apiService;
    @Autowired
    public ApiCodeController(ApiCodeService apiCodeService){
        super(apiCodeService);
    }

    @GetMapping("/manage")
    public String getKnowledgeIndex(ModelMap modelMap){
        List<TweiApi> apis = apiService.selectList();
        modelMap.addAttribute("apis",apis);
        return "backend/api/apicode_manage";
    }

    @PostMapping("/manage/json")
    @ResponseBody
    public ServerResponse getKnowLedgeJson(TweiApiCode apiCode){
        List<TweiApiCode> apiCodes = service.selectList(apiCode);
        return ServerResponse.createBySuccess(apiCodes);
    }
}
