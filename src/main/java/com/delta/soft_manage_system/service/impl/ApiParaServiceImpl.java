/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ApiParaServiceImpl
 * Author:   anywhere
 * Date:     3/23 0023 18:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.delta.soft_manage_system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.delta.common.utils.ServerResponse;
import com.delta.common.utils.StringUtil;
import com.delta.soft_manage_system.AutoInjectUserId.AutoUserId;
import com.delta.soft_manage_system.dao.TweiApiParaDao;
import com.delta.soft_manage_system.dto.TweiApiPara;
import com.delta.soft_manage_system.entitycheck.ActionType;
import com.delta.soft_manage_system.entitycheck.EntityCheck;
import com.delta.soft_manage_system.service.ApiParaService;
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
public class ApiParaServiceImpl extends BaseServiceImpl<TweiApiParaDao, TweiApiPara> implements ApiParaService {

    @Autowired
    public ApiParaServiceImpl(TweiApiParaDao apiParaDao){
        super(apiParaDao);
    }

    @Override
    @AutoUserId(tableName = "twei_api_para", idField = "paraId", clazz="com.delta.soft_manage_system.dto.TweiApiPara")
    @EntityCheck(action = ActionType.INSERT, user = true)
    public ServerResponse<TweiApiPara> insertOne(TweiApiPara apiPara) {
        int count = dao.insert(apiPara);
        if (count != 1) {
            return ServerResponse.createByErrorMessage("添加失敗");
        }
        return ServerResponse.createBySuccess(apiPara);
    }

    @Override
    protected EntityWrapper<TweiApiPara> getDeleteAndUpdateWrapper(TweiApiPara tweiApiPara) {
        EntityWrapper<TweiApiPara> wrapper = new EntityWrapper<>();
        wrapper.eq("para_id",tweiApiPara.getParaId());
        wrapper.eq("data_version", tweiApiPara.getDataVersion());
        return wrapper;
    }

    @Override
    protected TweiApiPara updateDataVersion(TweiApiPara tweiApiPara) {
        tweiApiPara.setDataVersion(tweiApiPara.getDataVersion() + 1);
        return tweiApiPara;
    }

    @Override
    public List<TweiApiPara> selectList(TweiApiPara apiPara) {
        EntityWrapper<TweiApiPara> wrapper = new EntityWrapper<>();
        if (apiPara == null || StringUtil.isBlank(apiPara.getApiId())) {
            return new ArrayList<>();
        }
        wrapper.eq("api_id", apiPara.getApiId());
        return dao.selectList(wrapper);
    }
}