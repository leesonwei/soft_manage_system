/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DictTypeServiceImpl
 * Author:   anywhere
 * Date:     3/23 0023 17:58
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.delta.soft_manage_system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.delta.soft_manage_system.common.ServerResponse;
import com.delta.soft_manage_system.dao.TweiDictTypeDao;
import com.delta.soft_manage_system.dto.TweiDictType;
import com.delta.soft_manage_system.entitycheck.ActionType;
import com.delta.soft_manage_system.entitycheck.EntityCheck;
import com.delta.soft_manage_system.service.DictService;
import com.delta.soft_manage_system.service.DictTypeService;
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
 * @date 3/23 0023
 * @since 1.0.0
 */
@Service("dictTypeService")
@Slf4j
public class DictTypeServiceImpl extends BaseServiceImpl<TweiDictTypeDao,TweiDictType> implements DictTypeService {

    @Autowired
    private Chinese4PinYin chinese4PinYin;
    @Autowired
    private DictService dictService;

    @Autowired
    public DictTypeServiceImpl(TweiDictTypeDao dictTypeDao){
        super(dictTypeDao);
    }

    @Override
    @EntityCheck(action = ActionType.INSERT, user = true)
    public ServerResponse<TweiDictType> insertOne(TweiDictType dictType) {
        if (!StringUtil.isBlank(dictType.getTypeName())) {
            String er = ZhConverterUtil.convertToSimple(dictType.getTypeName());
            dictType.setTypeId(chinese4PinYin.getAllFirstLetter(er).toUpperCase());
        }
        return super.insertOne(dictType);
    }

    @Override
    @EntityCheck(action = ActionType.DELETE, user = true)
    public ServerResponse<TweiDictType> deleteOne(TweiDictType dictType) {
        int count =  dictService.getSubDictCount(dictType.getTypeId());
        if (count > 0) {
            return ServerResponse.createByErrorMessage("不能刪除,該類下面存在子類,需清空子類才能完成刪除");
        }
        return super.deleteOne(dictType);
    }

    @Override
    protected EntityWrapper<TweiDictType> getDeleteAndUpdateWrapper(TweiDictType dictType) {
        EntityWrapper<TweiDictType> wrapper = new EntityWrapper<>();
        wrapper.eq("data_version", dictType.getDataVersion());
        wrapper.eq("type_id", dictType.getTypeId());
        return wrapper;
    }

    @Override
    protected TweiDictType updateDataVersion(TweiDictType dictType) {
        dictType.setDataVersion(dictType.getDataVersion() + 1);
        return dictType;
    }

}