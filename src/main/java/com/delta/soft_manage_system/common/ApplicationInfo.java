package com.delta.soft_manage_system.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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

    @Override
    public String toString(){
        return String.format("-------------應用名稱:%s," +
                        "應用版本:%s-------------",
                this.name,
                this.version);
    }
}

