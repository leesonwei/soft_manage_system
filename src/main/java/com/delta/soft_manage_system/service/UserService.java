package com.delta.soft_manage_system.service;

import com.delta.soft_manage_system.common.ServerResponse;
import com.delta.soft_manage_system.dto.User;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 2019/3/19 14:02
 * @Author LIZONG.WEI
 */

public interface UserService {

    /**
     * login
     * @param user
     * @return
     */
    public ServerResponse<User> login(User user);
}