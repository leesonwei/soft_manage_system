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
import com.delta.common.utils.Chinese4PinYin;
import com.delta.common.utils.ServerResponse;
import com.delta.common.utils.StringUtil;
import com.delta.soft_manage_system.dao.TweiDictTypeDao;
import com.delta.soft_manage_system.dto.TweiDictType;
import com.delta.soft_manage_system.entitycheck.ActionType;
import com.delta.soft_manage_system.entitycheck.EntityCheck;
import com.delta.soft_manage_system.service.DictService;
import com.delta.soft_manage_system.service.DictTypeService;
import com.github.houbb.opencc4j.util.ZhConverterUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author anywhere
 * @date 3/23 0023
 * @since 1.0.0
 */
@Service
@Slf4j
public class DictTypeServiceImpl extends BaseServiceImpl<TweiDictTypeDao,TweiDictType> implements DictTypeService {

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
            dictType.setTypeId(Chinese4PinYin.getInstant().getAllFirstLetter(er).toUpperCase());
        }
        dictType.setFlag(0);
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

    @Override
    public List<TweiDictType> selectList(TweiDictType dictType) {
        EntityWrapper<TweiDictType> wrapper = new EntityWrapper<>();
        if (null != dictType && null != dictType.getFlag()) {
            wrapper.eq("flag", dictType.getFlag());
        }
        return dao.selectList(wrapper);
    }

    @Override
    public ServerResponse<TweiDictType> checkOne(TweiDictType dictType) {
        TweiDictType origin = dao.selectById(dictType);
        if (null == origin) {
            return ServerResponse.createByErrorMessage("審核對象不存在");
        }
        if (origin.getFlag() == 1) {
            return ServerResponse.createByErrorMessage("對象已經是審核狀態");
        }
        origin.setFlag(1);
        origin.setCheckBy(dictType.getCheckBy());
        origin.setCheckAt(Calendar.getInstance().getTime());
        return this.updateOne(origin);
    }
}