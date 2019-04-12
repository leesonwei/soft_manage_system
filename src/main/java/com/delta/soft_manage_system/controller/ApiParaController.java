package com.delta.soft_manage_system.controller;

import com.delta.common.utils.ServerResponse;
import com.delta.soft_manage_system.dto.TweiApi;
import com.delta.soft_manage_system.dto.TweiApiPara;
import com.delta.soft_manage_system.service.ApiParaService;
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
 * @Classname ApiParaController
 * @Date 2019/3/27 08:38
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@Controller
@RequestMapping("/admin/apipara")
public class ApiParaController extends BaseController<ApiParaService, TweiApiPara> {
    @Autowired
    private ApiService apiService;

    @Autowired
    public ApiParaController(ApiParaService apiParaService){
        super(apiParaService);
    }
    @GetMapping("/manage")
    public String getKnowledgeIndex(ModelMap modelMap){
        List<TweiApi> apis = apiService.selectList();
        modelMap.addAttribute("apis",apis);
        setActiveMenu("6");
        return "backend/api/apipara_manage";
    }

    @PostMapping("/manage/json")
    @ResponseBody
    public ServerResponse getKnowLedgeJson(TweiApiPara apiPara){
        List<TweiApiPara> apis = service.selectList(apiPara);
        return ServerResponse.createBySuccess(apis);
    }
}
