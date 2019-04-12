package com.delta.soft_manage_system.authcontroller;

import com.delta.auth.Service.RoleService;
import com.delta.auth.dto.TweiRole;
import com.delta.auth.dto.TweiRoleAuth;
import com.delta.auth.dto.TweiUser;
import com.delta.common.constant.GlobalConst;
import com.delta.common.utils.FastJsonUtil;
import com.delta.common.utils.ServerResponse;
import com.delta.soft_manage_system.log2db.Log2db;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @Classname RoleController
 * @Date 2019/4/9 11:10
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@Controller
@RequestMapping("/admin/role")
public class RoleController extends BaseController<RoleService, TweiRole> {
    @Autowired
    public RoleController(RoleService roleService) {
        super(roleService);
    }
    public final String menuid = "1200";

    @GetMapping("/manage")
    public String getRoleIndex(HttpSession session){
        setActiveMenu("4");
        Map<String,Object> button = (Map<String,Object>)session.getAttribute(GlobalConst.AUTHVALUE);
        session.setAttribute(GlobalConst.SINGLEAUTHVALUE, button.get(menuid));
        return "backend/auth/role_manage";
    }

    @PostMapping("/manage/json")
    @ResponseBody
    public ServerResponse getRoleJson(HttpServletRequest request){
        TweiUser user = (TweiUser)request.getSession().getAttribute(GlobalConst.CURRENT_USER);
        List<TweiRole> roles = service.getRoles(user.getUserid());
        return ServerResponse.createBySuccess(roles);
    }

    @Log2db("SETAUTHS")
    @PostMapping("/setauths/json")
    @ResponseBody
    public ServerResponse setRoles(String json){
        List<TweiRoleAuth> roleAuths = FastJsonUtil.toList(json,TweiRoleAuth.class);
        return service.setAuths(roleAuths);
    }
    @GetMapping("/getroles")
    @ResponseBody
    public ServerResponse getroles(HttpServletRequest request, String userid){
        TweiUser user = (TweiUser)request.getSession().getAttribute(GlobalConst.CURRENT_USER);
        List<TweiRole> roles = service.getRoles(user.getUserid());
        List<TweiRole> oweRoles = service.oweRoles(userid);
        for (TweiRole role:roles) {
            if (oweRoles.contains(role)) {
                role.setSelected(true);
            } else {
                role.setSelected(false);
            }
        }
        return ServerResponse.createBySuccess(roles);
    }

}
