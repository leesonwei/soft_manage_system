package com.delta.soft_manage_system.entitycheck;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname EmailRule
 * @Date 2019/4/3 16:59
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@Target( ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailRule {
    String value() default "";
}
