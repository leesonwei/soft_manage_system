package com.delta.soft_manage_system.entitycheck;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname Check
 * @Date 2019/3/25 16:40
 * @Author LIZONG.WEI
 * @Since 1.8
 */


@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EntityCheck {
    boolean user() default false;
    /**
     * 執行的動作
     * @return
     */
    ActionType action() default ActionType.NONE;
}


