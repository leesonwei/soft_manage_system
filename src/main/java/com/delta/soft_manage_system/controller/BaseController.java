package com.delta.soft_manage_system.controller;

import com.delta.common.utils.ServerResponse;
import com.delta.soft_manage_system.service.BaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Classname BaseController
 * @Date 2019/3/26 16:42
 * @Author LIZONG.WEI
 * @Since 1.8
 */
public abstract class BaseController<T extends BaseService,K> {

    protected  T service;

    //public BaseController(){}

    public BaseController(T t){
        this.service = t;
    }


    @PostMapping("/insert")
    @ResponseBody
    public ServerResponse<K> insertOne(K k, HttpSession session){
        return service.insertOne(k);
    }

    @PostMapping("/delete")
    @ResponseBody
    public ServerResponse<K> deleteOne(K k,HttpSession session){
        return service.deleteOne(k);
    }

    @PostMapping("/update")
    @ResponseBody
    public ServerResponse<K> updateOne(K k, HttpSession session){
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
}
