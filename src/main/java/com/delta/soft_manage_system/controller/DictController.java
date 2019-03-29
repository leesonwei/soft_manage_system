package com.delta.soft_manage_system.controller;

import com.delta.soft_manage_system.common.GlobalConst;
import com.delta.soft_manage_system.common.ResponseCode;
import com.delta.soft_manage_system.common.ServerResponse;
import com.delta.soft_manage_system.dto.TweiDict;
import com.delta.soft_manage_system.dto.TweiDictType;
import com.delta.soft_manage_system.dto.User;
import com.delta.soft_manage_system.service.DictService;
import com.delta.soft_manage_system.service.DictTypeService;
import com.delta.soft_manage_system.utils.StringUtil;
import com.delta.soft_manage_system.vo.DictVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname DictTypeController
 * @Description
 * @Date 2019/3/21 16:59
 * @Author LIZONG.WEI
 */
@Controller
@RequestMapping("/admin/dict")
public class DictController extends BaseController<DictService, TweiDict> {
    @Autowired
    private DictTypeService dictTypeService;

    @Autowired
    public DictController(DictService dictService){
        super(dictService);
    }

    @GetMapping("/manage")
    public String manage(String typeId, ModelMap model){
        model = getModel(typeId, model);
        return "backend/dict/dict_manage";
    }

    private ModelMap getModel(String typeId, ModelMap model){
        List<TweiDictType> typeList = dictTypeService.selectList();
        List<DictVo> list = new ArrayList<>();
        if (StringUtil.isBlank(typeId) && (typeList != null || typeList.size() > 0)) {
            typeId = typeList.get(0).getTypeId();
        }
        if (!typeList.isEmpty()) {
            list = service.selectList(typeId);
        }
        model.addAttribute("typeList",typeList);
        model.addAttribute("dicts",list);
        return model;
    }

    @PostMapping("/manage/json")
    @ResponseBody
    public Object manageJson(String typeId, ModelMap model){
        List<TweiDictType> typeList = dictTypeService.selectList();
        List<DictVo> list = new ArrayList<>();
        if (StringUtil.isBlank(typeId) && (typeList != null || typeList.size() > 0)) {
            typeId = typeList.get(0).getTypeId();
        }
        if (!typeList.isEmpty()) {
            list = service.selectList(typeId);
        }
        return list;
    }

    @PostMapping("/check")
    @ResponseBody
    public ServerResponse check(TweiDict dict, HttpSession session){
        User user = (User)session.getAttribute(GlobalConst.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        dict.setCheckBy(user.getUserid());
        return service.checkOne(dict);
    }
}
