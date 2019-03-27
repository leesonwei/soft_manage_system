package com.delta.soft_manage_system.controller;

import com.delta.soft_manage_system.dto.TweiKnowledge;
import com.delta.soft_manage_system.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Classname KnowlegeController
 * @Date 2019/3/27 10:27
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@Controller
public class KnowlegeController extends BaseController<KnowledgeService, TweiKnowledge> {
    @Autowired
    public KnowlegeController(KnowledgeService knowledgeService) {
        super(knowledgeService);
    }
}
