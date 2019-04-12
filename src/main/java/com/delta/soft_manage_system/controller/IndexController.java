package com.delta.soft_manage_system.controller;

import com.delta.auth.Service.MenuService;
import com.delta.auth.common.MenuUtil;
import com.delta.auth.dto.TweiMenuVo;
import com.delta.auth.dto.TweiUser;
import com.delta.common.constant.GlobalConst;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Classname IndexController
 * @Description
 * @Date 2019/3/21 13:55
 * @Author LIZONG.WEI
 */
@Controller
@Slf4j
public class IndexController {

    @Autowired
    private MenuService menuService;

    @ApiOperation(value="首页",notes = "项目首页")
    @GetMapping("/index")
    public String index(){
        return "front/index";
    }

    @ApiOperation(value="管理首页",notes = "项目管理首页")
    @GetMapping("/admin/index")
    public String adminIndex(HttpServletRequest request){
        TweiUser user = (TweiUser) request.getSession().getAttribute(GlobalConst.CURRENT_USER);
        if (null == user) {
            return "redirect:/user/login";
        }
        List<TweiMenuVo> menus = (List<TweiMenuVo>)request.getSession().getAttribute(GlobalConst.MENUS);
        List<TweiMenuVo> menuTree = MenuUtil.getMenuTree(menus);
        menuTree = MenuUtil.setActive("2",menuTree);
        request.getSession().setAttribute("menuTree", menuTree);
        return "backend/index";
    }

}
