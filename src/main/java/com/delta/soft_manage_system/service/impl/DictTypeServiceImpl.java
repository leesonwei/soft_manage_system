/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DictTypeServiceImpl
 * Author:   anywhere
 * Date:     3/23 0023 17:58
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.delta.soft_manage_system.service.impl;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.delta.soft_manage_system.common.ActionType;
import com.delta.soft_manage_system.common.EntityCheck;
import com.delta.soft_manage_system.common.ResponseCode;
import com.delta.soft_manage_system.common.ServerResponse;
import com.delta.soft_manage_system.dao.TweiDictTypeDao;
import com.delta.soft_manage_system.dto.TweiDictType;
import com.delta.soft_manage_system.service.DictTypeService;
import com.delta.soft_manage_system.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author anywhere
 * @create 3/23 0023
 * @since 1.0.0
 */
@Service
@Slf4j
public class DictTypeServiceImpl implements DictTypeService {

    @Autowired
    private TweiDictTypeDao dictTypeDao;

    private ServerResponse<TweiDictType> check(TweiDictType dictType, ActionType actionType){
        ServerResponse<TweiDictType> response = ServerResponse.createBySuccess(dictType);
        Class cls = dictType.getClass();
        try {
            Field field = cls.getDeclaredField("typeId");
            Annotation annotation = field.getAnnotation(TableId.class);
            if (((TableId) annotation).type() != IdType.AUTO && ((TableId) annotation).type() != IdType.UUID) {
                if (null == dictType.getTypeId()){
                    response = ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),
                            "類型id不能為空");
                    return response;
                }
            }
        } catch (NoSuchFieldException e) {
            log.error("===============補獲異常=================", e);
        }

        if ((!actionType.equals(ActionType.DELETE)) && StringUtil.isBlank(dictType.getTypeName())){
            response = ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),
                    "類型名稱不能為空");
            return response;
        }
        if (!actionType.equals(ActionType.INSERT)) {
            if (null == dictType.getDataVersion()){
                response = ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),
                        "數據版本不能為空");
                return response;
            }
            TweiDictType tweiDictType = dictTypeDao.selectById(dictType);
            if (!dictType.getDataVersion().equals(tweiDictType.getDataVersion())) {
                response = ServerResponse.createByErrorMessage(
                        String.format("%s失敗,數據已被其他人更新", actionType.equals(ActionType.DELETE) ? "刪除" : "更新"));
                return response;
            }
            if (actionType.equals(ActionType.UPDATE)) {
                dictType.setDataVersion(tweiDictType.getDataVersion() + 1);
                response = ServerResponse.createBySuccess(dictType);
            }
        }
        return response;
    }

    @Override
    @EntityCheck
    public ServerResponse<TweiDictType> insertOne(TweiDictType dictType, ServerResponse<TweiDictType> response) {
        //ServerResponse<TweiDictType> response = check(dictType, ActionType.INSERT);
        if (!response.isSuccess()) {
            return response;
        }
        int count = dictTypeDao.insert(dictType);
        if (count != 1) {
            response = ServerResponse.createByErrorMessage("更新失敗");
        }
        return response;
    }

    @Override
    public ServerResponse<TweiDictType> deleteOne(TweiDictType dictType) {
        ServerResponse<TweiDictType> response = check(dictType, ActionType.DELETE);
        if (!response.isSuccess()) {
            return response;
        }
        int count = dictTypeDao.deleteById(dictType);
        if (count != 1) {
            response = ServerResponse.createByErrorMessage("刪除失敗");
        }
        return response;
    }

    @Override
    public ServerResponse<TweiDictType> updateOne(TweiDictType dictType) {
        ServerResponse<TweiDictType> response = check(dictType, ActionType.UPDATE);
        if (!response.isSuccess()) {
            return response;
        }
        int count = dictTypeDao.updateById(response.getData());
        if (count != 1) {
            response = ServerResponse.createByErrorMessage("更新失敗");
        }
        return response;
    }

    @Override
    public TweiDictType selectOne(TweiDictType dictType) {
        return dictTypeDao.selectOne(dictType);
    }

    @Override
    public List<TweiDictType> selectList() {
        return dictTypeDao.selectList(new EntityWrapper<>());
    }
}