package com.delta.soft_manage_system.controller;

import com.delta.auth.dto.TweiUser;
import com.delta.common.code.ResponseCode;
import com.delta.common.constant.GlobalConst;
import com.delta.common.utils.ServerResponse;
import com.delta.soft_manage_system.dto.TweiDictType;
import com.delta.soft_manage_system.service.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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
    public final String menuid = "2100";

    @GetMapping("/manage")
    public String getDictTypeIndex(HttpSession session){
        setActiveMenu("5");
        Map<String,Object> button = (Map<String,Object>)session.getAttribute(GlobalConst.AUTHVALUE);
        session.setAttribute(GlobalConst.SINGLEAUTHVALUE, button.get(menuid));
        return "backend/dict/dicttype_manage";
    }

    @PostMapping("/manage/json")
    @ResponseBody
    public ServerResponse getDictTypeJson(TweiDictType dictType){
        List<TweiDictType> types = service.selectList(dictType);
        return ServerResponse.createBySuccess(types);
    }

    @PostMapping("/check")
    @ResponseBody
    public ServerResponse check(TweiDictType dictType, HttpSession session){
        TweiUser user = (TweiUser)session.getAttribute(GlobalConst.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        dictType.setCheckBy(user.getUserid());
        return service.checkOne(dictType);
    }

}
