package com.delta.soft_manage_system.controller;

import com.delta.common.constant.GlobalConst;
import com.delta.common.utils.ServerResponse;
import com.delta.soft_manage_system.dto.DictVo;
import com.delta.soft_manage_system.dto.TweiApi;
import com.delta.soft_manage_system.dto.TweiDict;
import com.delta.soft_manage_system.service.ApiService;
import com.delta.soft_manage_system.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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
    private DictService dictService;
    public final String menuid = "3100";

    @Autowired
    public ApiController(ApiService apiService){
        super(apiService);
    }
    @GetMapping("/manage")
    public String getKnowledgeIndex(ModelMap modelMap, HttpSession session){
        TweiDict dict = new TweiDict();
        dict.setTypeId(GlobalConst.API_TYPE);
        dict.setFlag(1);
        List<DictVo> dicts = dictService.selectList(dict);
        modelMap.addAttribute("dicts", dicts);
        setActiveMenu("6");
        Map<String,Object> button = (Map<String,Object>)session.getAttribute(GlobalConst.AUTHVALUE);
        session.setAttribute(GlobalConst.SINGLEAUTHVALUE, button.get(menuid));
        return "backend/api/api_manage";
    }

    @PostMapping("/manage/json")
    @ResponseBody
    public ServerResponse getKnowLedgeJson(TweiApi api){
        List<TweiApi> apis = service.selectList(api);
        return ServerResponse.createBySuccess(apis);
    }
}
