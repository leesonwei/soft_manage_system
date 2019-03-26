/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DictServiceImpl
 * Author:   anywhere
 * Date:     3/23 0023 17:59
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.delta.soft_manage_system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.delta.soft_manage_system.common.ServerResponse;
import com.delta.soft_manage_system.dao.TweiDictDao;
import com.delta.soft_manage_system.dto.TweiDict;
import com.delta.soft_manage_system.service.DictService;
import com.delta.soft_manage_system.utils.Chinese4PinYin;
import com.delta.soft_manage_system.utils.StringUtil;
import com.github.houbb.opencc4j.util.ZhConverterUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@Slf4j
public class DictServiceImpl extends BaseServiceImpl<TweiDictDao, TweiDict> implements DictService {

    public DictServiceImpl(){}

    @Autowired
    public DictServiceImpl(TweiDictDao dictDao){
        super(dictDao);
    }

    @Override
    public ServerResponse<TweiDict> insertOne(TweiDict dict){
        dict = generatePyCode(dict);
        return super.insertOne(dict);
    }

    @Override
    public ServerResponse<TweiDict> updateOne(TweiDict dict){
        dict = generatePyCode(dict);
        return super.updateOne(dict);
    }

    @Override
    protected EntityWrapper<TweiDict> getDeleteAndUpdateWrapper(TweiDict tweiDict) {
        EntityWrapper<TweiDict> wrapper = new EntityWrapper<>();
        wrapper.eq("data_version", tweiDict.getDataVersion());
        wrapper.eq("type_id", tweiDict.getTypeId());
        wrapper.eq("dict_id", tweiDict.getDictId());
        return wrapper;
    }

    @Override
    protected TweiDict updateDataVersion(TweiDict tweiDict) {
        tweiDict.setDataVersion(tweiDict.getDataVersion() + 1);
        return tweiDict;
    }

    private TweiDict generatePyCode(TweiDict dict){
        if (!StringUtil.isBlank(dict.getDictName())) {
            Chinese4PinYin trans = new Chinese4PinYin();
            dict.setPycode(trans.getAllFirstLetter(ZhConverterUtil.convertToSimple(dict.getDictName())));
        }
        return dict;
    }
}