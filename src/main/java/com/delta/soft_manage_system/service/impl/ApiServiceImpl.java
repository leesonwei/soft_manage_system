/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ApiServiceImpl
 * Author:   anywhere
 * Date:     3/23 0023 17:59
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.delta.soft_manage_system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.delta.soft_manage_system.dao.TweiApiDao;
import com.delta.soft_manage_system.dto.TweiApi;
import com.delta.soft_manage_system.service.ApiService;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author anywhere
 * @create 3/23 0023
 * @since 1.0.0
 */
public class ApiServiceImpl extends BaseServiceImpl<TweiApiDao, TweiApi> implements ApiService {

    @Override
    protected EntityWrapper<TweiApi> getDeleteAndUpdateWrapper(TweiApi tweiApi) {
        return null;
    }

    @Override
    protected TweiApi updateDataVersion(TweiApi tweiApi) {
        return null;
    }
}