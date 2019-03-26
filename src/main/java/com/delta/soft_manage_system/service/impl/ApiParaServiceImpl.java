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

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author anywhere
 * @create 3/23 0023
 * @since 1.0.0
 */
public class ApiParaServiceImpl extends BaseServiceImpl<TweiApiParaDao, TweiApiPara> implements ApiParaService {


    @Override
    protected EntityWrapper<TweiApiPara> getDeleteAndUpdateWrapper(TweiApiPara tweiApiPara) {
        return null;
    }

    @Override
    protected TweiApiPara updateDataVersion(TweiApiPara tweiApiPara) {
        return null;
    }
}