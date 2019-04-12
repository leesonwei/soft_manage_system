package com.delta.soft_manage_system.controller;

import com.delta.auth.common.MenuUtil;
import com.delta.auth.dto.TweiMenuVo;
import com.delta.common.constant.GlobalConst;
import com.delta.common.utils.ServerResponse;
import com.delta.soft_manage_system.dto.Log;
import com.delta.soft_manage_system.service.LogService;
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
 * @Classname LogController
 * @Date 2019/4/9 09:35
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@Controller
@RequestMapping("/admin/log")
public class LogController {

    @Autowired
    private LogService logService;
    public final String menuid = "5000";

    @GetMapping("/manage")
    public String getLog(ModelMap modelMap, HttpSession session){
        List<TweiMenuVo> menus = (List<TweiMenuVo>)session.getAttribute(GlobalConst.MENUTREE);
        menus = MenuUtil.setActive("16",menus);
        session.setAttribute(GlobalConst.MENUTREE, menus);
        Map<String,Object> button = (Map<String,Object>)session.getAttribute(GlobalConst.AUTHVALUE);
        session.setAttribute(GlobalConst.SINGLEAUTHVALUE, button.get(menuid));
        return "backend/log/log_manage";
    }

    @PostMapping("/manage/json")
    @ResponseBody
    public ServerResponse getLogJson(){
        List<Log> logs = logService.selectList();
        return ServerResponse.createBySuccess(logs);
    }
}
