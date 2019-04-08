package com.delta.soft_manage_system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.delta.common.utils.ServerResponse;
import com.delta.common.utils.StringUtil;
import com.delta.soft_manage_system.AutoInjectUserId.AutoUserId;
import com.delta.soft_manage_system.dao.TweiKnowledgeDao;
import com.delta.soft_manage_system.dto.TweiKnowledge;
import com.delta.soft_manage_system.entitycheck.ActionType;
import com.delta.soft_manage_system.entitycheck.EntityCheck;
import com.delta.soft_manage_system.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname KnowledgeServiceImpl
 * @Date 2019/3/27 10:22
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@Service
public class KnowledgeServiceImpl extends BaseServiceImpl<TweiKnowledgeDao, TweiKnowledge> implements KnowledgeService {

    @Autowired
    public KnowledgeServiceImpl(TweiKnowledgeDao tweiKnowledgeDao) {
        super(tweiKnowledgeDao);
    }

    @Override
    @AutoUserId(tableName = "twei_knowledge", idField = "knowId", clazz="com.delta.soft_manage_system.dto.TweiKnowledge")
    @EntityCheck(action = ActionType.INSERT, user = true)
    public ServerResponse<TweiKnowledge> insertOne(TweiKnowledge knowledge){
        return super.insertOne(knowledge);
    }
    @Override
    protected EntityWrapper<TweiKnowledge> getDeleteAndUpdateWrapper(TweiKnowledge tweiKnowledge) {
        EntityWrapper<TweiKnowledge> wrapper = new EntityWrapper<>();
        wrapper.eq("KNOW_ID",tweiKnowledge.getKnowId());
        wrapper.eq("data_version", tweiKnowledge.getDataVersion());
        return wrapper;
    }

    @Override
    protected TweiKnowledge updateDataVersion(TweiKnowledge tweiKnowledge) {
        tweiKnowledge.setDataVersion(tweiKnowledge.getDataVersion() + 1);
        return tweiKnowledge;
    }

    @Override
    public List<TweiKnowledge> selectList(TweiKnowledge knowledge) {
        EntityWrapper<TweiKnowledge> wrapper = new EntityWrapper<>();
        if (knowledge == null || StringUtil.isBlank(knowledge.getKnowType())) {
            return new ArrayList<>();
        }
        wrapper.eq("know_type", knowledge.getKnowType());
        return dao.selectList(wrapper);
    }
}
