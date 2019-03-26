package com.delta.soft_manage_system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.delta.soft_manage_system.dto.TweiDict;
import org.springframework.stereotype.Repository;

/**
 * @Classname TweiDict
 * @Date 2019.3.22
 * @author lizong.wei
 * @Since 1.8
 */
@Repository("dictDao")
public interface TweiDictDao extends BaseMapper<TweiDict> {

}