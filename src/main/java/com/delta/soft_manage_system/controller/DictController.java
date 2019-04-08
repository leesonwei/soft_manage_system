package com.delta.soft_manage_system.controller;

import com.delta.auth.dto.TweiUser;
import com.delta.common.code.ResponseCode;
import com.delta.common.constant.GlobalConst;
import com.delta.common.utils.ServerResponse;
import com.delta.common.utils.StringUtil;
import com.delta.soft_manage_system.dto.DictVo;
import com.delta.soft_manage_system.dto.TweiDict;
import com.delta.soft_manage_system.dto.TweiDictType;
import com.delta.soft_manage_system.service.DictService;
import com.delta.soft_manage_system.service.DictTypeService;
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
    public String manage(ModelMap model){
        model.addAttribute("typeList", getModel());
        return "backend/dict/dict_manage";
    }

    private List<TweiDictType> getModel(){
        TweiDictType dictType = new TweiDictType();
        dictType.setFlag(1);
        List<TweiDictType> typeList = dictTypeService.selectList(dictType);
        return typeList;
    }

    @PostMapping("/manage/json")
    @ResponseBody
    public Object manageJson(TweiDict dict, ModelMap model){
        List<DictVo> list = new ArrayList<>();
        if (StringUtil.isBlank(dict.getTypeId())) {
            List<TweiDictType> typeList = getModel();
            if (typeList != null && typeList.size() > 0) {
                dict.setTypeId(typeList.get(0).getTypeId());
            }
        }
        if (!StringUtil.isBlank(dict.getTypeId())) {
            list = service.selectList(dict);
        }
        return list;
    }

    @PostMapping("/check")
    @ResponseBody
    public ServerResponse check(TweiDict dict, HttpSession session){
        TweiUser user = (TweiUser)session.getAttribute(GlobalConst.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        dict.setCheckBy(user.getUserid());
        return service.checkOne(dict);
    }
}
