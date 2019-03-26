package com.delta.soft_manage_system.controller;

import com.delta.soft_manage_system.dto.TweiDict;
import com.delta.soft_manage_system.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname DictTypeController
 * @Description
 * @Date 2019/3/21 16:59
 * @Author LIZONG.WEI
 */
@Controller
@RequestMapping("/admin/dict")
public class DictController extends BaseController<DictService, TweiDict> {

    public DictController(){}

    @Autowired
    public DictController(DictService dictService){
        super(dictService);
    }
}
