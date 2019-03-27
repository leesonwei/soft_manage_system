package com.delta.soft_manage_system.AutoInjectUserId;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname AutoUserId
 * @Date 2019/3/27 15:59
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoUserId {
    String tableName();
    String prefix() default "";
    String idField();
    String clazz();
}
