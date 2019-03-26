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
import com.delta.soft_manage_system.dao.TweiApiTypeDao;
import com.delta.soft_manage_system.dto.TweiApiType;
import com.delta.soft_manage_system.service.ApiTypeService;
import org.springframework.stereotype.Service;

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

    @Override
    protected EntityWrapper<TweiApiType> getDeleteAndUpdateWrapper(TweiApiType tweiApiType) {
        return null;
    }

    @Override
    protected TweiApiType updateDataVersion(TweiApiType tweiApiType) {
        return null;
    }
}