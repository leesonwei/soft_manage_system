/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ApiCodeService
 * Author:   anywhere
 * Date:     3/23 0023 16:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.delta.soft_manage_system.service;

import com.delta.soft_manage_system.dto.TweiApiCode;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author anywhere
 * @create 3/23 0023
 * @since 1.0.0
 */
public interface ApiCodeService {
    /**
     * 新增
     * @param apiCode
     * @return
     */
    int insertOne(TweiApiCode apiCode);

    /**
     * 刪除
     * @param apiCode
     * @return
     */
    int deleteOne(TweiApiCode apiCode);

    /**
     * 更新
     * @param apiCode
     * @return
     */
    int updateOne(TweiApiCode apiCode);

    /**
     * 查找一個對象
     * @param apiCode
     * @return
     */
    TweiApiCode selectOne(TweiApiCode apiCode);

    /**
     * 查找list對象
     * @param apiCode
     * @return
     */
    List<TweiApiCode> selectList(TweiApiCode apiCode);

}