package com.delta.soft_manage_system.AutoField;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Classname AutoFieldAspect
 * @Date 2019/3/28 08:00
 * @Author LIZONG.WEI
 *@Since 1.8
 */
@Aspect
@Slf4j
@Component
public class AutoFieldAspect {

    @Pointcut("@annotation(com.delta.soft_manage_system.AutoField.AutoFieldDto)")
    public void doAspect(){}

    @AfterReturning(returning = "returning", pointcut = "doAspect()")
    public Object actionAspect(JoinPoint joinPoint, Object returning){
        Object ret = null;
        if (returning instanceof List<?>) {
            
        }
        return ret;
    }
}
