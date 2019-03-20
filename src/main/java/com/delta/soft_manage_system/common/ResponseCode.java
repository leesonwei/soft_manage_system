/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ResponseCode
 * Author:   anywhere
 * Date:     3/20 0020 21:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.delta.soft_manage_system.common;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author anywhere
 * @create 3/20 0020
 * @since 1.0.0
 */
public enum ResponseCode {

    /**
     * response success info
     */
    SUCCESS(0,"SUCCESS"),

    /**
     * response error info
     */
    ERROR(1,"ERROR"),

    /**
     * unlogin info
     */
    NEED_LOGIN(10,"NEED_LOGIN"),

    /**
     * bad request para info
     */
    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT");

    /**
     * 编码
     */
    private final int code;

    /**
     * 描述信息
     */
    private final String desc;


    ResponseCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }

}