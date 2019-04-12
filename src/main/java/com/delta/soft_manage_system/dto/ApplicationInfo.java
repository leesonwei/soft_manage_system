package com.delta.soft_manage_system.dto;

import com.delta.auth.dto.TweiAuth;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Classname ApplicationInfo
 * @Description
 * @Date 2019/3/19 15:54
 * @Author LIZONG.WEI
 */
@Data
@Component
public class ApplicationInfo {
    @Value("${spring.application.name}")
    private String name;

    private String version;

    @Value("${spring.application.debug}")
    private Boolean debug;

    @Value("${spring.application.company}")
    private String company;

    private List<TweiAuth> auths;

}

