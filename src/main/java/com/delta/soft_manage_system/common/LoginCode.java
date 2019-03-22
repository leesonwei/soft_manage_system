package com.delta.soft_manage_system.common;

import lombok.Getter;

/**
 * @Classname LoginCode
 * @Date 2019/3/22 16:20
 * @Author lizong.wei
 * @Since 1.8
 */
@Getter
public enum LoginCode {
    //用戶名為空
    USERID_IS_NULL(10001, "用戶名不能為空"),

    PASSWORD_IS_NULL(10002, "用戶名不能為空"),
    //用戶不存在
    USER_NOT_EXSISTE(10003, "用戶不存在"),

    PASSWORD_UNCURRECT(10004, "密碼不正確");

    /**
     * 编码
     */
    private final int code;

    /**
     * 描述信息
     */
    private final String desc;

    LoginCode(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

}
