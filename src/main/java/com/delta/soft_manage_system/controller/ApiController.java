package com.delta.soft_manage_system.controller;

import com.delta.soft_manage_system.common.ServerResponse;
import com.delta.soft_manage_system.dto.TweiApi;
import com.delta.soft_manage_system.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    @GetMapping("/manage")
    public String getKnowledgeIndex(){
        return "backend/api/api_manage";
    }

    @PostMapping("/manage/json")
    @ResponseBody
    public ServerResponse getKnowLedgeJson(TweiApi api){
        List<TweiApi> apis = service.selectList(api);
        return ServerResponse.createBySuccess(api);
    }
}
