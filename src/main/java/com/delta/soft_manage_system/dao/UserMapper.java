package com.delta.soft_manage_system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.delta.soft_manage_system.dto.User;
import org.springframework.stereotype.Repository;

/**
 * @Classname UserMapper
 * @Description
 * @Date 2019/3/19 13:56
 * @Author LIZONG.WEI
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * get total user count
     * @return
     */
    int getUserCount();

    /**
     * get total user count
     * @return
     */
    int listCount();

}
