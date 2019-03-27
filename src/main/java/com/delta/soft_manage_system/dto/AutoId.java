package com.delta.soft_manage_system.dto;

import lombok.Data;

/**
 * @Classname AutoId
 * @Date 2019/3/27 10:09
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@Data
public class AutoId {
    private String tableName;
    private String prefix;
    private String autoid;
}
