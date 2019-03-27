package com.delta.soft_manage_system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.delta.soft_manage_system.dto.AutoId;
import org.springframework.stereotype.Repository;

/**
 * @Classname TweiApiCode
 * @Date 2019.3.22
 * @author lizong.wei
 * @Since 1.8
 */
@Repository("autoIdDao")
public interface AutoIdDao extends BaseMapper<AutoId> {

    /**
     *
     * @param autoId
     */
    void getAutoId(AutoId autoId);
}