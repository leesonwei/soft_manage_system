/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ApiCodeService
 * Author:   anywhere
 * Date:     3/23 0023 18:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.delta.soft_manage_system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.delta.common.code.ResponseCode;
import com.delta.common.utils.ServerResponse;
import com.delta.common.utils.StringUtil;
import com.delta.soft_manage_system.dao.TweiApiCodeDao;
import com.delta.soft_manage_system.dto.TweiApiCode;
import com.delta.soft_manage_system.entitycheck.ActionType;
import com.delta.soft_manage_system.entitycheck.EntityCheck;
import com.delta.soft_manage_system.service.ApiCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class ApiCodeServiceImpl extends BaseServiceImpl<TweiApiCodeDao, TweiApiCode> implements ApiCodeService {

    @Autowired
    public ApiCodeServiceImpl(TweiApiCodeDao apiCodeDao){
        super(apiCodeDao);
    }

    @Override
    @EntityCheck(action = ActionType.INSERT, user = true)
    public ServerResponse<TweiApiCode> insertOne(TweiApiCode apiCode) {
        TweiApiCode exsist = dao.selectById(apiCode);
        if (null != exsist) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        int count = dao.insert(apiCode);
        if (count != 1) {
            return ServerResponse.createByErrorMessage("添加失敗");
        }
        return ServerResponse.createBySuccess(apiCode);
    }

    @Override
    protected EntityWrapper<TweiApiCode> getDeleteAndUpdateWrapper(TweiApiCode apiCode) {
        EntityWrapper<TweiApiCode> wrapper = new EntityWrapper<>();
        wrapper.eq("code_id",apiCode.getCodeId());
        wrapper.eq("data_version", apiCode.getDataVersion());
        return wrapper;
    }

    @Override
    protected TweiApiCode updateDataVersion(TweiApiCode apiCode) {
        apiCode.setDataVersion(apiCode.getDataVersion() + 1);
        return apiCode;
    }

    @Override
    public List<TweiApiCode> selectList(TweiApiCode apiCode) {
        EntityWrapper<TweiApiCode> wrapper = new EntityWrapper<>();
        if (apiCode == null || StringUtil.isBlank(apiCode.getApiId())) {
            return new ArrayList<>();
        }
        wrapper.eq("api_id", apiCode.getApiId());
        return dao.selectList(wrapper);
    }
}