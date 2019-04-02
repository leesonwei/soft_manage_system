package com.delta.soft_manage_system.controller;

import com.delta.soft_manage_system.common.ServerResponse;
import com.delta.soft_manage_system.dto.TweiDictType;
import com.delta.soft_manage_system.service.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Classname DictTypeController
 * @Date 2019/3/25 13:28
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@Controller
@RequestMapping("/admin/dicttype")
public class DictTypeController extends BaseController<DictTypeService, TweiDictType> {

    @Autowired
    public DictTypeController(DictTypeService dictTypeService){
        super(dictTypeService);
    }

    @GetMapping("/manage")
    public String getDictTypeIndex(){
        return "backend/dict/dicttype_manage";
    }

    @PostMapping("/manage/json")
    @ResponseBody
    public ServerResponse getDictTypeJson(TweiDictType dictType){
        List<TweiDictType> types = service.selectList(dictType);
        return ServerResponse.createBySuccess(types);
    }

}
