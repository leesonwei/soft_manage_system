package com.delta.soft_manage_system.service;

import com.delta.soft_manage_system.dto.User;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 2019/3/19 14:02
 * @Author LIZONG.WEI
 */

public interface UserService {
    /**
     *
     * @param user
     * @return
     */
    public int insert(User user);

    /**
     *
     * @return
     */
    public int getUserCount();
}
