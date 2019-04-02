/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ApiTypeService
 * Author:   anywhere
 * Date:     3/23 0023 17:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.delta.soft_manage_system.service;

import com.delta.soft_manage_system.dto.TweiApiType;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author anywhere
 * @create 3/23 0023
 * @since 1.0.0
 */
public interface ApiTypeService extends BaseService<TweiApiType> {
    /**
     * 查找list對象
     * @return
     */
    List<TweiApiType> selectList(TweiApiType apiType);
}