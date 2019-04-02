package com.delta.soft_manage_system.service;

import com.delta.soft_manage_system.dto.TweiKnowledge;

import java.util.List;

/**
 * @Classname KnowledgeService
 * @Date 2019/3/27 10:21
 * @Author LIZONG.WEI
 * @Since 1.8
 */
public interface KnowledgeService extends BaseService<TweiKnowledge> {

    /**
     * 查找list對象
     * @return
     */
    List<TweiKnowledge> selectList(TweiKnowledge knowledge);
}
