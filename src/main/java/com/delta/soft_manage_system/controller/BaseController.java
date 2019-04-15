package com.delta.soft_manage_system.controller;

import com.delta.auth.common.MenuUtil;
import com.delta.auth.dto.TweiMenuVo;
import com.delta.common.constant.GlobalConst;
import com.delta.common.utils.ServerResponse;
import com.delta.soft_manage_system.log2db.Log2db;
import com.delta.soft_manage_system.service.BaseService;
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

    public BaseController(T t){
        this.service = t;
    }

    @PostMapping("/insert")
    @Log2db("INSERT")
    @ResponseBody
    public ServerResponse<K> insertOne(K k){
        return service.insertOne(k);
    }

    @PostMapping("/delete")
    @Log2db("DELETE")
    @ResponseBody
    public ServerResponse<K> deleteOne(K k){
        return service.deleteOne(k);
    }

    @PostMapping("/update")
    @Log2db("UPDATE")
    @ResponseBody
    public ServerResponse<K> updateOne(K k){
        return service.updateOne(k);
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
        List<TweiMenuVo> menus = (List<TweiMenuVo>)request.getSession().getAttribute(GlobalConst.MENUTREE);
        menus = MenuUtil.setActive(id,menus);
        request.getSession().setAttribute(GlobalConst.MENUTREE, menus);
    }
}
