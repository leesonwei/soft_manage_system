package com.delta.soft_manage_system.controller;

import com.delta.soft_manage_system.common.ServerResponse;
import com.delta.soft_manage_system.dto.TweiKnowledge;
import com.delta.soft_manage_system.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    public KnowlegeController(KnowledgeService knowledgeService) {
        super(knowledgeService);
    }
    @GetMapping("/manage")
    public String getKnowledgeIndex(){
        return "backend/knowledge/knowledge_manage";
    }

    @PostMapping("/manage/json")
    @ResponseBody
    public ServerResponse getKnowLedgeJson(TweiKnowledge knowledge){
        List<TweiKnowledge> knowledges = service.selectList(knowledge);
        return ServerResponse.createBySuccess(knowledges);
    }
}
