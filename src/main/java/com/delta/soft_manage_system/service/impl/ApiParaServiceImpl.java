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
import com.delta.soft_manage_system.dao.TweiApiParaDao;
import com.delta.soft_manage_system.dto.TweiApiPara;
import com.delta.soft_manage_system.service.ApiParaService;
import com.delta.soft_manage_system.utils.StringUtil;
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
public class ApiParaServiceImpl extends BaseServiceImpl<TweiApiParaDao, TweiApiPara> implements ApiParaService {

    @Autowired
    public ApiParaServiceImpl(TweiApiParaDao apiParaDao){
        super(apiParaDao);
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
        if (apiPara != null) {
            if (!StringUtil.isBlank(apiPara.getApiId())){
                wrapper.eq("api_id", apiPara.getApiId());
            }
        }
        return dao.selectList(wrapper);
    }
}