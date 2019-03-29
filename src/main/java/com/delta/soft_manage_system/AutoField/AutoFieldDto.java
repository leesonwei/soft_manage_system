package com.delta.soft_manage_system.AutoField;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname AutoField
 * @Date 2019/3/28 08:01
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoFieldDto {
}
