/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DictTypeService
 * Author:   anywhere
 * Date:     3/23 0023 16:24
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.delta.soft_manage_system.service;

import com.delta.common.utils.ServerResponse;
import com.delta.soft_manage_system.dto.TweiDictType;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author anywhere
 * @create 3/23 0023
 * @since 1.0.0
 */
public interface DictTypeService extends BaseService<TweiDictType> {
    /**
     * 查找list對象
     * @return
     */
    List<TweiDictType> selectList(TweiDictType dictType);

    ServerResponse<TweiDictType> checkOne(TweiDictType dictType);
}