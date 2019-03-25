package com.delta.soft_manage_system.controller;

import com.delta.soft_manage_system.common.GlobalConst;
import com.delta.soft_manage_system.common.ResponseCode;
import com.delta.soft_manage_system.common.ServerResponse;
import com.delta.soft_manage_system.dto.TweiDictType;
import com.delta.soft_manage_system.dto.User;
import com.delta.soft_manage_system.service.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.List;

/**
 * @Classname DictTypeController
 * @Date 2019/3/25 13:28
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@RestController
@RequestMapping("/admin/dicttype")
public class DictTypeController {

    @Autowired
    private DictTypeService dictTypeService;

    @PostMapping("/insert")
    public ServerResponse<TweiDictType> insertOne(TweiDictType dictType, HttpSession session){
        User user = (User)session.getAttribute(GlobalConst.CURRENT_USER);
        if (null == user) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "請先登錄再進行操作");
        }
        dictType.setCreateBy(user.getUserid());
        dictType.setCreateAt(Calendar.getInstance().getTime());
        dictType.setDataVersion(0);
        return dictTypeService.insertOne(dictType, ServerResponse.createBySuccess());
    }

    @PostMapping("/delete")
    public ServerResponse<TweiDictType> deleteOne(TweiDictType dictType,HttpSession session){
        User user = (User)session.getAttribute(GlobalConst.CURRENT_USER);
        if (null == user) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "請先登錄再進行操作");
        }
        return dictTypeService.deleteOne(dictType);
    }

    @PostMapping("/update")
    public ServerResponse<TweiDictType> updateOne(TweiDictType dictType, HttpSession session){
        User user = (User)session.getAttribute(GlobalConst.CURRENT_USER);
        if (null == user) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "請先登錄再進行操作");
        }
        dictType.setUpdateBy(user.getUserid());
        dictType.setUpdateAt(Calendar.getInstance().getTime());
        return dictTypeService.updateOne(dictType);
    }

    @GetMapping("/select/one")
    public TweiDictType selectOne(TweiDictType dictType){
        return dictTypeService.selectOne(dictType);
    }

    @GetMapping("/select/list")
    public List<TweiDictType> selectList(){
        return dictTypeService.selectList();
    }
}
