package com.delta.soft_manage_system.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.delta.common.utils.ServerResponse;
import com.delta.soft_manage_system.entitycheck.ActionType;
import com.delta.soft_manage_system.entitycheck.EntityCheck;

import java.util.List;

/**
 * @Classname BaseServiceImpl
 * @Date 2019/3/26 15:19
 * @Author LIZONG.WEI
 * @Since 1.8
 */
public abstract class BaseServiceImpl<T extends BaseMapper,K> {

    protected T dao;

    //public BaseServiceImpl(){ }

    public BaseServiceImpl(T dao){
        this.dao = dao;
    }

    @EntityCheck(action = ActionType.INSERT, user = true)
    public ServerResponse<K> insertOne(K k) {
        int count = dao.insert(k);
        if (count != 1) {
            return ServerResponse.createByErrorMessage("添加失敗");
        }
        return ServerResponse.createBySuccess(k);
    }

    @EntityCheck(action = ActionType.DELETE, user = true)
    public ServerResponse<K> deleteOne(K k) {
        EntityWrapper<K> wrapper = getDeleteAndUpdateWrapper(k);
        if (null == wrapper || wrapper.isEmptyOfWhere()) {
            return ServerResponse.createByErrorMessage("刪除條件不能為空");
        }
        int count = dao.delete(wrapper);
        if (count != 1) {
            return ServerResponse.createByErrorMessage("刪除失敗");
        }
        return ServerResponse.createBySuccess(k);
    }

    @EntityCheck(action = ActionType.UPDATE, user = true)
    public ServerResponse<K> updateOne(K k) {
        EntityWrapper<K> wrapper = getDeleteAndUpdateWrapper(k);
        k = updateDataVersion(k);
        int count = dao.update(k, wrapper);
        if (count != 1) {
            return ServerResponse.createByErrorMessage("更新失敗");
        }
        return ServerResponse.createBySuccess(k);
    }

    public K selectOne(K k) {
        return (K)dao.selectOne(k);
    }

    public List<K> selectList() {
        return dao.selectList(new EntityWrapper<>());
    }

    protected abstract EntityWrapper<K> getDeleteAndUpdateWrapper(K k);

    protected abstract K updateDataVersion(K k);
}
