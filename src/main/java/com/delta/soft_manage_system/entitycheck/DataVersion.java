package com.delta.soft_manage_system.entitycheck;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname DataVersion 數據版本號註解
 * @Date 2019/3/26 11:14
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataVersion {
}
