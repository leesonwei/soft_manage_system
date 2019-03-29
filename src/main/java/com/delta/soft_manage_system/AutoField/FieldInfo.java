package com.delta.soft_manage_system.AutoField;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname FieldInfo
 * @Date 2019/3/28 09:35
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldInfo {
    String value();
    int order() default 0;
}
