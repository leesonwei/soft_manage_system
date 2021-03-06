/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DictService
 * Author:   anywhere
 * Date:     3/23 0023 16:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.delta.soft_manage_system.service;

import com.delta.common.utils.ServerResponse;
import com.delta.soft_manage_system.dto.TweiDict;
import com.delta.soft_manage_system.dto.DictVo;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author anywhere
 * @create 3/23 0023
 * @since 1.0.0
 */
public interface DictService extends BaseService<TweiDict> {

    /**
     * 獲取子類型數量
     * @param typeId
     * @return
     */
    int getSubDictCount(String typeId);

    List<DictVo> selectList(TweiDict dict);

    ServerResponse<TweiDict> checkOne(TweiDict tweiDict);
}