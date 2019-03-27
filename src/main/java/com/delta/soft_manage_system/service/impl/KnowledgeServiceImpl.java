package com.delta.soft_manage_system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.delta.soft_manage_system.dao.TweiKnowledgeDao;
import com.delta.soft_manage_system.dto.TweiKnowledge;
import com.delta.soft_manage_system.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    protected EntityWrapper<TweiKnowledge> getDeleteAndUpdateWrapper(TweiKnowledge tweiKnowledge) {
        EntityWrapper<TweiKnowledge> wrapper = new EntityWrapper<>();
        wrapper.eq("data_version", tweiKnowledge.getDataVersion());
        return wrapper;
    }

    @Override
    protected TweiKnowledge updateDataVersion(TweiKnowledge tweiKnowledge) {
        tweiKnowledge.setDataVersion(tweiKnowledge.getDataVersion() + 1);
        return tweiKnowledge;
    }
}
