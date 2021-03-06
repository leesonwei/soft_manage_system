package com.delta.soft_manage_system.config;

import com.delta.auth.Service.AuthService;
import com.delta.common.utils.DateUtil;
import com.delta.soft_manage_system.dto.ApplicationInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Classname ApplicationConfig
 * @Description
 * @Date 2019/3/19 16:00
 * @Author LIZONG.WEI
 */
@Component
@Slf4j
public class ApplicationConfig implements CommandLineRunner {
    @Autowired
    private ApplicationInfo applicationInfo;
    @Autowired
    private AuthService authService;

    @Override
    public void run(String... args) throws Exception {
        applicationInfo.setVersion(DateUtil.getDateVersion());
        log.info(String.format("--------------应用名称:%s--------------", applicationInfo.getName()));
        log.info(String.format("--------------版本号:%s--------------", applicationInfo.getVersion()));
        applicationInfo.setAuths(authService.selectList());
    }
}
