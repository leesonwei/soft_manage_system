package com.delta.soft_manage_system.vo;

import com.delta.soft_manage_system.dto.TweiDict;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Classname DictVo
 * @Date 2019/3/28 10:20
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DictVo extends TweiDict {
    private String typeName;
    private String createByer;
    private String updateByer;
    private String checkByer;
}
