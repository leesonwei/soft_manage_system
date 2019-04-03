/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ApiTypeServiceImpl
 * Author:   anywhere
 * Date:     3/23 0023 18:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.delta.soft_manage_system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.delta.soft_manage_system.AutoInjectUserId.AutoUserId;
import com.delta.soft_manage_system.common.ServerResponse;
import com.delta.soft_manage_system.dao.TweiApiTypeDao;
import com.delta.soft_manage_system.dto.TweiApiType;
import com.delta.soft_manage_system.entitycheck.ActionType;
import com.delta.soft_manage_system.entitycheck.EntityCheck;
import com.delta.soft_manage_system.service.ApiTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class ApiTypeServiceImpl extends BaseServiceImpl<TweiApiTypeDao, TweiApiType> implements ApiTypeService {

    @Autowired
    public ApiTypeServiceImpl(TweiApiTypeDao apiTypeDao){
        super(apiTypeDao);
    }

    @Override
    @AutoUserId(tableName = "twei_api_type", idField = "apiTypeId", clazz="com.delta.soft_manage_system.dto.TweiApiType")
    @EntityCheck(action = ActionType.INSERT, user = true)
    public ServerResponse<TweiApiType> insertOne(TweiApiType apiType) {
        int count = dao.insert(apiType);
        if (count != 1) {
            return ServerResponse.createByErrorMessage("添加失敗");
        }
        return ServerResponse.createBySuccess(apiType);
    }
    @Override
    protected EntityWrapper<TweiApiType> getDeleteAndUpdateWrapper(TweiApiType tweiApiType) {
        EntityWrapper<TweiApiType> wrapper = new EntityWrapper<>();
        wrapper.eq("data_version", tweiApiType.getDataVersion());
        wrapper.eq("api_type_id", tweiApiType.getApiTypeId());
        return wrapper;
    }

    @Override
    protected TweiApiType updateDataVersion(TweiApiType tweiApiType) {
        tweiApiType.setDataVersion(tweiApiType.getDataVersion()+1);
        return tweiApiType;
    }

    @Override
    public List<TweiApiType> selectList(TweiApiType apiType) {
        EntityWrapper<TweiApiType> wrapper = new EntityWrapper<>();
        if (apiType != null) {

        }
        return dao.selectList(wrapper);
    }
}