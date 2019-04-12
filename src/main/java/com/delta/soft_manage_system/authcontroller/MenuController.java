package com.delta.soft_manage_system.authcontroller;

import com.delta.auth.Service.MenuService;
import com.delta.auth.dto.TweiAuth;
import com.delta.auth.dto.TweiMenu;
import com.delta.auth.dto.TweiMenuVo;
import com.delta.common.constant.GlobalConst;
import com.delta.common.utils.ServerResponse;
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
 * @Classname MenuController
 * @Date 2019/4/9 15:32
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@Controller
@RequestMapping("/admin/menu")
public class MenuController extends BaseController<MenuService, TweiMenu> {
    @Autowired
    public MenuController(MenuService menuService) {
        super(menuService);
    }
    public final String menuid = "1100";

    @GetMapping("/manage")
    public String getMenuIndex(ModelMap modelMap, HttpSession session){
        List<TweiAuth> auths = service.getMenuAuths();
        modelMap.addAttribute("auths", auths);
        setActiveMenu("4");
        Map<String,Object> button = (Map<String,Object>)session.getAttribute(GlobalConst.AUTHVALUE);
        session.setAttribute(GlobalConst.SINGLEAUTHVALUE, button.get(menuid));
        return "backend/auth/menu_manage";
    }

    @PostMapping("/manage/json")
    @ResponseBody
    public ServerResponse getMenuJson(TweiMenuVo menu){
        List<TweiMenuVo> menus = service.selectList(menu);
        return ServerResponse.createBySuccess(menus);
    }
}
