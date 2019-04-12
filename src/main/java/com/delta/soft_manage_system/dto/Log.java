package com.delta.soft_manage_system.dto;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Classname Log
 * @Date 2019/4/8 18:31
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@Data
@TableName("twei_app_log")
public class Log implements Serializable {
    @TableId
    private String logId;

    private String logType;

    private String logContent;

    private Date logAt;

    private String logBy;

    private String logResult;
}
