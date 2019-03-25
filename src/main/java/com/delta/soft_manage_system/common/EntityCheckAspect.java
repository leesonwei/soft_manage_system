package com.delta.soft_manage_system.common;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Classname EntityCheckAspect
 * @Date 2019/3/25 16:43
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@Aspect
@Component
@Slf4j
public class EntityCheckAspect {

    @Pointcut("@annotation(com.delta.soft_manage_system.common.EntityCheck)")
    public void doAction(){}

    @Before("doAction()")
    public void doCheck(JoinPoint joinPoint ) throws Exception {

    }
}
