package com.delta.soft_manage_system.authcontroller;

import com.delta.auth.Service.BaseService;
import com.delta.auth.common.MenuUtil;
import com.delta.auth.dto.TweiMenuVo;
import com.delta.common.utils.ServerResponse;
import com.delta.soft_manage_system.log2db.Log2db;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Classname BaseController
 * @Date 2019/3/26 16:42
 * @Author LIZONG.WEI
 * @Since 1.8
 */
public abstract class BaseController<T extends BaseService,K> {
    @Autowired
    private HttpServletRequest request;

    protected  T service;

    //public BaseController(){}

    public BaseController(T t){
        this.service = t;
    }


    @PostMapping("/insert")
    @Log2db("INSERT")
    @ResponseBody
    public ServerResponse<K> insertOne(K k, HttpServletRequest request){
        return service.insertOne(k, request);
    }

    @PostMapping("/delete")
    @Log2db("DELETE")
    @ResponseBody
    public ServerResponse<K> deleteOne(K k, HttpServletRequest request){
        return service.deleteOne(k, request);
    }

    @PostMapping("/update")
    @Log2db("UPDATE")
    @ResponseBody
    public ServerResponse<K> updateOne(K k, HttpServletRequest request){
        return service.updateOne(k, request);
    }

    @GetMapping("/select/one")
    @ResponseBody
    public K selectOne(K k){
        return (K)service.selectOne(k);
    }

    @GetMapping("/select/list")
    @ResponseBody
    public List<K> selectList(){
        return service.selectList();
    }

    protected void setActiveMenu(String id){
        List<TweiMenuVo> menus = (List<TweiMenuVo>)request.getSession().getAttribute("menuTree");
        menus = MenuUtil.setActive(id,menus);
        request.getSession().setAttribute("menuTree", menus);
    }
}
