package com.delta.soft_manage_system.authcontroller;

import com.alibaba.druid.support.http.WebStatFilter;
import com.delta.auth.Service.AuthService;
import com.delta.auth.Service.MenuService;
import com.delta.auth.Service.RoleService;
import com.delta.auth.Service.UserService;
import com.delta.auth.dto.TweiAuth;
import com.delta.auth.dto.TweiMenuVo;
import com.delta.auth.dto.TweiUser;
import com.delta.auth.dto.TweiUserRole;
import com.delta.common.constant.GlobalConst;
import com.delta.common.constant.JWTConstant;
import com.delta.common.utils.EncryptUtil;
import com.delta.common.utils.FastJsonUtil;
import com.delta.common.utils.ServerResponse;
import com.delta.common.utils.TokenMgr;
import com.delta.soft_manage_system.interceptor.XssRequestWrapper;
import com.delta.soft_manage_system.log2db.Log2db;
import com.delta.soft_manage_system.utils.AuthsUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Classname UserController
 * @Date 2019/3/19 14:13
 * @Author LIZONG.WEI
 */
@Controller
@Slf4j
public class UserController extends BaseController<UserService, TweiUser> {

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private AuthService authService;
    public final String menuid = "1100";

    @Autowired
    public UserController(UserService userService) {
        super(userService);
    }

    @ApiOperation(value="获取登录页面",notes = "获取登录页面")
    @GetMapping("/user/login")
    public String getLoginFile(HttpServletRequest request){
        return "backend/login";
    }

    @ApiOperation(value="登入",notes = "登入系统")
    @Log2db("LOGIN")
    @PostMapping("/user/login")
    @ResponseBody
    public ServerResponse<String> login(TweiUser user, XssRequestWrapper request, WebStatFilter.StatHttpServletResponseWrapper response){
        ServerResponse<TweiUser> serverResponse = service.login(user);
        ServerResponse<String> res = null;
        if (serverResponse.isSuccess()) {
            TweiUser successUser = serverResponse.getData();
            request.getSession().setAttribute(GlobalConst.CURRENT_USER,successUser);
            String token = TokenMgr.createJWT(successUser.getUserid(), JWTConstant.JWT_ISS,TokenMgr.generalSubject(user), JWTConstant.JWT_TTL);
            response.addHeader(GlobalConst.TOKEN, token);
            Cookie cookie = new Cookie(GlobalConst.TOKEN, token);
            response.addCookie(cookie);
            res = ServerResponse.createBySuccess(token);
            //獲取用戶菜單
            List<TweiMenuVo> menus = new ArrayList<>();
            if (successUser.getRole().getRoleLevel() == 0) {
                menus = menuService.selectList(new TweiMenuVo());
            } else {
                menus = menuService.selectUserMenus(user.getUserid());
            }
            request.getSession().setAttribute(GlobalConst.MENUS,menus);
            //獲取用戶菜單的權限值
            List<TweiAuth> auths = authService.getOweAuths(successUser.getRole().getRoleId());
            request.getSession().setAttribute(GlobalConst.AUTHS,auths);
            Map<String,Integer> authValues = AuthsUtil.getAuthValue(auths);
            request.getSession().setAttribute(GlobalConst.AUTHVALUE,authValues);
        } else {
            res = ServerResponse.createByErrorCodeMessage(serverResponse.getStatus(),serverResponse.getMsg());
        }
        return res;
    }

    @ApiOperation(value="退出",notes = "退出登录")
    @Log2db("LOGOUT")
    @GetMapping("/user/logout")
    public String logout(XssRequestWrapper request){
        request.getSession().setMaxInactiveInterval(1);
        request.changeSessionId();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (GlobalConst.TOKEN.equals(cookie.getName())) {
                cookie.setMaxAge(-1);
            }
        }
        return "redirect:login";
    }

    @PostMapping("/admin/user/insert")
    @Log2db("INSERT")
    @ResponseBody
    @Override
    public ServerResponse<TweiUser> insertOne(TweiUser user, HttpServletRequest request){
        user.setPassword(EncryptUtil.getInstance().MD5(user.getPassword()));
        return service.insertOne(user, request);
    }

    @PostMapping("/admin/user/delete")
    @Log2db("DELETE")
    @ResponseBody
    @Override
    public ServerResponse<TweiUser> deleteOne(TweiUser k, HttpServletRequest request){
        return service.deleteOne(k, request);
    }

    @PostMapping("/admin/user/update")
    @Log2db("UPDATE")
    @ResponseBody
    @Override
    public ServerResponse<TweiUser> updateOne(TweiUser k, HttpServletRequest request){
        return service.updateOne(k, request);
    }

    @GetMapping("/admin/user/select/one")
    @ResponseBody
    @Override
    public TweiUser selectOne(TweiUser k){
        return (TweiUser)service.selectOne(k);
    }

    @GetMapping("/admin/user/select/list")
    @ResponseBody
    @Override
    public List<TweiUser> selectList(){
        return service.selectList();
    }

    @Log2db("SETROLES")
    @PostMapping("/admin/user/setroles/json")
    @ResponseBody
    public ServerResponse<TweiUserRole> setRoles(String json){
        List<TweiUserRole> userRoles = FastJsonUtil.toList(json,TweiUserRole.class);
        return service.setRoles(userRoles);
    }

    @GetMapping("/admin/user/manage")
    public String getKnowledgeIndex(HttpSession session){
        setActiveMenu("4");
        Map<String,Object> button = (Map<String,Object>)session.getAttribute(GlobalConst.AUTHVALUE);
        session.setAttribute(GlobalConst.SINGLEAUTHVALUE, button.get(menuid));
        return "backend/auth/user_manage";
    }

    @PostMapping("/admin/user/manage/json")
    @ResponseBody
    public ServerResponse getKnowLedgeJson(HttpServletRequest request){
        TweiUser user = (TweiUser) request.getSession().getAttribute(GlobalConst.CURRENT_USER);
        List<TweiUser> users = service.selectListByRole(user.getUserid());
        return ServerResponse.createBySuccess(users);
    }

}
