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
import com.delta.soft_manage_system.dao.TweiApiCodeDao;
import com.delta.soft_manage_system.dto.TweiApiCode;
import com.delta.soft_manage_system.service.ApiCodeService;
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
public class ApiCodeServiceImpl extends BaseServiceImpl<TweiApiCodeDao, TweiApiCode> implements ApiCodeService {

    @Autowired
    public ApiCodeServiceImpl(TweiApiCodeDao apiCodeDao){
        super(apiCodeDao);
    }

    @Override
    protected EntityWrapper<TweiApiCode> getDeleteAndUpdateWrapper(TweiApiCode apiCode) {
        return null;
    }

    @Override
    protected TweiApiCode updateDataVersion(TweiApiCode apiCode) {
        return null;
    }

    @Override
    public List<TweiApiCode> selectList(TweiApiCode apiCode) {
        EntityWrapper<TweiApiCode> wrapper = new EntityWrapper<>();
        if (apiCode != null) {

        }
        return dao.selectList(wrapper);
    }
}