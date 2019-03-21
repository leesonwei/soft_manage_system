package com.delta.soft_manage_system.service.impl;

import com.delta.soft_manage_system.common.ServerResponse;
import com.delta.soft_manage_system.dao.UserMapper;
import com.delta.soft_manage_system.dto.User;
import com.delta.soft_manage_system.service.UserService;
import com.delta.soft_manage_system.utils.EncryptUtil;
import com.delta.soft_manage_system.utils.StringUtil;
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
    public ServerResponse<User> login(User user) {
        ServerResponse<User> res = ServerResponse.createBySuccess();
        if (StringUtil.isBlank(user.getUserid())) {
            res = ServerResponse.createByErrorCodeMessage(10001, "用戶名不能為空");
            return res;
        }
        if (StringUtil.isBlank(user.getPassword())) {
            res = ServerResponse.createByErrorCodeMessage(10002, "密碼不能為空");
            return res;
        }
        User dbUser = (User)userMapper.selectById(user);
        if (null == dbUser) {
            res = ServerResponse.createByErrorCodeMessage(10003, "用戶不存在");
            return res;
        }
        if (!EncryptUtil.getInstance().MD5(user.getPassword()).equals(dbUser.getPassword())) {
            res = ServerResponse.createByErrorCodeMessage(10004, "密碼不正確");
        } else {
            res = ServerResponse.createBySuccess(dbUser);
        }
        return res;
    }
}
