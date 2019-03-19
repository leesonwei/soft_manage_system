package com.delta.soft_manage_system.service.impl;

import com.delta.soft_manage_system.dao.UserMapper;
import com.delta.soft_manage_system.dto.User;
import com.delta.soft_manage_system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 2019/3/19 14:05
 * @Author LIZONG.WEI
 */

@Service("userService")
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insert(User user) {
        return 0;
    }

    @Override
    public int getUserCount() {
        User user = new User();
        user.setUserid("weilizong");
        user = userMapper.selectById(user);
        log.info(user.toString());
        return userMapper.getUserCount();
    }
}
