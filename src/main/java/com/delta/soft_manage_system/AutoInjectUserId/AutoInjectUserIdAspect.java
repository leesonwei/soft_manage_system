package com.delta.soft_manage_system.AutoInjectUserId;

import com.delta.common.utils.ServerResponse;
import com.delta.soft_manage_system.dao.AutoIdDao;
import com.delta.soft_manage_system.dto.AutoId;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Classname AutoInjectUserId
 * @Date 2019/3/27 15:55
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@Aspect
@Component
@Slf4j
public class AutoInjectUserIdAspect {

    @Autowired
    private AutoIdDao autoIdDao;

    @Pointcut("@annotation(com.delta.soft_manage_system.AutoInjectUserId.AutoUserId)")
    public void doInject(){}

    @Around("doInject()")
    public Object injectId(ProceedingJoinPoint joinPoint) throws Exception {
        Object ret = null;
        Signature sig = joinPoint.getSignature();
        MethodSignature methodSignature = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        methodSignature = (MethodSignature) sig;
        Object target = joinPoint.getTarget();
        Method currentMethod = null;
        Object[] args = null;
        currentMethod = target.getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());

        AutoUserId autoUserId = currentMethod.getAnnotation(AutoUserId.class);
        String prefix = "";
        if (null != autoUserId) {
            args = joinPoint.getArgs();
            Class clazz = Class.forName(autoUserId.clazz());
            for (Object obj : args) {
                boolean fill = false;
                if (clazz.isInstance(obj)) {
                    Field[] fields = clazz.getDeclaredFields();
                    //先獲取前綴
                    for (Field field : fields) {
                        field.setAccessible(true);
                        if (autoUserId.prefix().equals(field.getName())) {
                            prefix = (String) field.get(obj);
                            fill = true;
                            break;
                        }
                    }
                    if (!fill) {
                        prefix = autoUserId.prefix();
                    }
                    //獲取id值
                    fill = false;
                    for (Field field : fields) {
                        if (fill) {
                            break;
                        }
                        field.setAccessible(true);
                        if (autoUserId.idField().equals(field.getName())) {
                            AutoId autoId = new AutoId();
                            autoId.setTableName(autoUserId.tableName());
                            autoId.setPrefix(prefix);
                            autoIdDao.getAutoId(autoId);
                            if ("0".equals(autoId.getAutoid())) {
                                log.info("請求id參數:========>" + autoId.toString());
                                return ServerResponse.createByErrorMessage("獲取id出錯");
                            }
                            field.set(obj, autoId.getAutoid());
                            fill = true;
                        }
                    }
                    if (!fill) {
                        return ServerResponse.createByErrorMessage("id field 設置不正確");
                    }
                }
            }
        }
        try {
            ret = joinPoint.proceed(args);
        } catch (Throwable throwable) {
            log.info("====================執行目標方法異常============", throwable);
            return ServerResponse.createByErrorMessage(throwable.getMessage());
        }
        return ret;
    }
}
