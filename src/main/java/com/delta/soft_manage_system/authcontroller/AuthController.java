package com.delta.soft_manage_system.authcontroller;

import com.delta.auth.Service.AuthService;
import com.delta.auth.dto.TweiAuth;
import com.delta.common.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname AuthController
 * @Date 2019/4/9 16:49
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@Controller
@RequestMapping("/admin/auth")
public class AuthController extends BaseController<AuthService, TweiAuth> {
    @Autowired
    public AuthController(AuthService authService) {
        super(authService);
    }

    @GetMapping("/manage")
    public String getKnowledgeIndex(ModelMap modelMap){
        setActiveMenu("4");
        return "backend/auth/menu_manage";
    }

    @PostMapping("/manage/json")
    @ResponseBody
    public ServerResponse getAuthJson(String roleId){
        List<TweiAuth> auths = service.selectList();
        List<TweiAuth> oweAuths = service.getOweAuths(roleId);
        List<TweiAuth> newAuths = new ArrayList<>();
        for (TweiAuth auth:auths) {
            auth.setHasCheck(false);
            for (TweiAuth oweAuth:oweAuths) {
                if (auth.getAuthId().equals(oweAuth.getAuthId())) {
                    auth.setHasCheck(true);
                    break;
                }
            }
            newAuths.add(auth);
        }
        return ServerResponse.createBySuccess(newAuths);
    }

    private List<TweiAuth> getDealAuths(List<TweiAuth> auths,List<TweiAuth> oweAuths){

        return auths;
    }
}
