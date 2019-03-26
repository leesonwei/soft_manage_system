package com.delta.soft_manage_system.entitycheck;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname NullRule
 * @Date 2019/3/26 08:42
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NullRule {
    boolean able() default false;
    ActionType[] action() default ActionType.NONE;
    String name() default "";
    String value() default "不能設置為空";
}
