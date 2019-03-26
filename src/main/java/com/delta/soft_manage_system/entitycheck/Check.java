package com.delta.soft_manage_system.entitycheck;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname Check
 * @Date 2019/3/26 08:09
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Check {
    boolean id() default false;
    CheckId type() default CheckId.NONE;
    ActionType[] action() default ActionType.NONE;
}
