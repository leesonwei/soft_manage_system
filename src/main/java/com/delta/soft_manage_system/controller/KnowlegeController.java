package com.delta.soft_manage_system.controller;

import com.delta.common.constant.GlobalConst;
import com.delta.common.utils.ServerResponse;
import com.delta.soft_manage_system.dto.DictVo;
import com.delta.soft_manage_system.dto.TweiDict;
import com.delta.soft_manage_system.dto.TweiKnowledge;
import com.delta.soft_manage_system.service.DictService;
import com.delta.soft_manage_system.service.KnowledgeService;
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
 * @Classname KnowlegeController
 * @Date 2019/3/27 10:27
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@Controller
@RequestMapping("/admin/knowledge")
public class KnowlegeController extends BaseController<KnowledgeService, TweiKnowledge> {
    @Autowired
    private DictService dictService;
    public final String menuid = "4000";

    @Autowired
    public KnowlegeController(KnowledgeService knowledgeService) {
        super(knowledgeService);
    }
    @GetMapping("/manage")
    public String getKnowledgeIndex(ModelMap modelMap, HttpSession session){
        TweiDict dict = new TweiDict();
        dict.setTypeId(GlobalConst.KNOWLEDGE_TYPE);
        dict.setFlag(1);
        List<DictVo> dicts = dictService.selectList(dict);
        modelMap.addAttribute("dicts", dicts);
        setActiveMenu("15");
        Map<String,Object> button = (Map<String,Object>)session.getAttribute(GlobalConst.AUTHVALUE);
        session.setAttribute(GlobalConst.SINGLEAUTHVALUE, button.get(menuid));
        return "backend/knowledge/knowledge_manage";
    }

    @PostMapping("/manage/json")
    @ResponseBody
    public ServerResponse getKnowLedgeJson(TweiKnowledge knowledge){
        List<TweiKnowledge> knowledges = service.selectList(knowledge);
        return ServerResponse.createBySuccess(knowledges);
    }
}
