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
import com.delta.common.utils.Chinese4PinYin;
import com.delta.common.utils.ServerResponse;
import com.delta.common.utils.StringUtil;
import com.delta.soft_manage_system.AutoInjectUserId.AutoUserId;
import com.delta.soft_manage_system.dao.AutoIdDao;
import com.delta.soft_manage_system.dao.TweiDictDao;
import com.delta.soft_manage_system.dto.DictVo;
import com.delta.soft_manage_system.dto.TweiDict;
import com.delta.soft_manage_system.entitycheck.ActionType;
import com.delta.soft_manage_system.entitycheck.EntityCheck;
import com.delta.soft_manage_system.service.DictService;
import com.github.houbb.opencc4j.util.ZhConverterUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private AutoIdDao autoIdDao;

    @Autowired
    public DictServiceImpl(TweiDictDao dictDao){
        super(dictDao);
    }

    @Override
    @AutoUserId(tableName = "twei_dict", prefix="typeId", idField = "dictId", clazz="com.delta.soft_manage_system.dto.TweiDict")
    @EntityCheck(action = ActionType.INSERT, user = true)
    public ServerResponse<TweiDict> insertOne(TweiDict dict){
        dict = generatePyCode(dict);
        return super.insertOne(dict);
    }

    @Override
    @EntityCheck(action = ActionType.DELETE, user = true)
    public ServerResponse<TweiDict> deleteOne(TweiDict dict){
        TweiDict origin = dao.selectById(dict);
        if (null == origin) {
            return ServerResponse.createByErrorMessage("刪除對象不存在");
        }
        if (origin.getFlag() == 1) {
            return ServerResponse.createByErrorMessage("已審核不可刪除");
        }
        dict = generatePyCode(dict);
        return super.deleteOne(dict);
    }


    @Override
    @EntityCheck(action = ActionType.UPDATE, user = true)
    public ServerResponse<TweiDict> updateOne(TweiDict dict){
        TweiDict origin = dao.selectById(dict);
        if (null == origin) {
            return ServerResponse.createByErrorMessage("更新對象不存在");
        }
        if (origin.getFlag() == 1) {
            return ServerResponse.createByErrorMessage("已審核不可更新");
        }
        dict = generatePyCode(dict);
        return super.updateOne(dict);
    }

    @Override
    protected EntityWrapper<TweiDict> getDeleteAndUpdateWrapper(TweiDict tweiDict) {
        EntityWrapper<TweiDict> wrapper = new EntityWrapper<>();
        wrapper.eq("data_version", tweiDict.getDataVersion());
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
            dict.setPycode(Chinese4PinYin.getInstant().getAllFirstLetter(ZhConverterUtil.convertToSimple(dict.getDictName())));
        }
        return dict;
    }

    @Override
    public int getSubDictCount(String typeId) {
        TweiDict tweiDict = new TweiDict();
        tweiDict.setTypeId(typeId);
        return selectList(tweiDict).size();
    }

    @Override
    public List<DictVo> selectList(TweiDict tweiDict) {
        Map<String,Object> map = new HashMap<>();
        if (tweiDict != null) {
            if (!StringUtil.isBlank(tweiDict.getTypeId())){
                map.put("type_id", tweiDict.getTypeId());
            }
            if (null != tweiDict.getFlag()){
                map.put("flag", tweiDict.getFlag());
            }
        }
        List<DictVo> dicts = dao.selectListByVo(map);
        return dicts;
    }

    @Override
    public ServerResponse<TweiDict> checkOne(TweiDict tweiDict) {
        TweiDict origin = dao.selectById(tweiDict);
        if (null == origin) {
            return ServerResponse.createByErrorMessage("審核對象不存在");
        }
        if (origin.getFlag() == 1) {
            return ServerResponse.createByErrorMessage("對象已經是審核狀態");
        }
        origin.setFlag(1);
        origin.setCheckBy(tweiDict.getCheckBy());
        origin.setCheckAt(Calendar.getInstance().getTime());
        return this.updateOne(origin);
    }
}