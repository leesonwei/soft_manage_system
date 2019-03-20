package com.delta.soft_manage_system.config;

import com.delta.soft_manage_system.common.ApplicationInfo;
import com.delta.soft_manage_system.utils.DateUtil;
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

    @Override
    public void run(String... args) throws Exception {
        applicationInfo.setVersion(DateUtil.getDateVersion());
        log.info(String.format("--------------应用名称:%s--------------",applicationInfo.getName()));
        log.info(String.format("--------------版本号:%s--------------",applicationInfo.getVersion()));
    }
}
