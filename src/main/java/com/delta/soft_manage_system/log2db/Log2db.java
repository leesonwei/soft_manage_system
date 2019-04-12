package com.delta.soft_manage_system.log2db;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname Log2db
 * @Date 2019/4/8 18:31
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log2db {
    String value() default "select";
}
