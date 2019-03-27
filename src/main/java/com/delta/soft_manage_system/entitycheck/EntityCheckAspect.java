package com.delta.soft_manage_system.entitycheck;

import com.delta.soft_manage_system.common.GlobalConst;
import com.delta.soft_manage_system.common.ResponseCode;
import com.delta.soft_manage_system.common.ServerResponse;
import com.delta.soft_manage_system.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

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

    @Autowired
    private HttpSession session;

    @Pointcut("@annotation(com.delta.soft_manage_system.entitycheck.EntityCheck)")
    public void doAction(){}

    @Around("doAction()")
    public Object doCheck(ProceedingJoinPoint joinPoint ) throws Exception {

        ServerResponse response = ServerResponse.createBySuccess();
        Object ret = null;
        Object[] args = joinPoint.getArgs();
        Class<?>[] argTypes = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            argTypes[i] = args[i].getClass().getSuperclass();
        }

        //獲取方法註解--的action值
        Method method = null;
        try {
            method = joinPoint.getTarget().getClass()
                    .getMethod(joinPoint.getSignature().getName(), argTypes);
        } catch (Exception e) {
            log.info("====================反射獲取方法異常============", e);
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ERROR.getCode(),"程序內部出錯");
        }
        EntityCheck ma = method.getAnnotation(EntityCheck.class);

        if (ma != null) {
            User user = null;
            if (ma.user()) {
                user = (User)session.getAttribute(GlobalConst.CURRENT_USER);
            }
            if (user == null) {
                return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "請先登錄再進行操作");
            }
            //檢查規則
            List<ActionType> l = null;
            Object v = null;
            for (Object obj : args) {
                if (!response.isSuccess()) {
                    break;
                }
                Class clazz = obj.getClass();
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    if (!response.isSuccess()) {
                        break;
                    }
                    field.setAccessible(true);

                    //設置默認值
                    if ("createBy".equals(field.getName()) && ma.action() == ActionType.INSERT && ma.user()) {
                        field.set(obj, user.getUserid());
                    }
                    if ("updateBy".equals(field.getName()) && ma.action() == ActionType.UPDATE && ma.user()) {
                        field.set(obj, user.getUserid());
                    }
                    //設置默認時間
                    if ("createAt".equals(field.getName()) && ma.action() == ActionType.INSERT && ma.user()) {
                        field.set(obj, Calendar.getInstance().getTime());
                    }
                    if ("updateAt".equals(field.getName()) && ma.action() == ActionType.UPDATE && ma.user()) {
                        field.set(obj, Calendar.getInstance().getTime());
                    }

                    //檢查check註解
                    Check c = field.getAnnotation(Check.class);
                    if (c != null) {
                        l = Arrays.asList(c.action());
                        if (l.contains(ma.action()) && c.id() && (c.type() != CheckId.AUTO && c.type() != CheckId.ID_WORKER && c.type() != CheckId.UUID)) {
                            v = field.get(obj);
                            if (null == v) {
                                response = ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),
                                        "主鍵值不能為空");
                            }
                        }
                    }

                    //檢查nullrule註解
                    NullRule n = field.getAnnotation(NullRule.class);
                    if (null != n) {
                        l = Arrays.asList(n.action());
                        if (l.contains(ma.action())) {
                            v = field.get(obj);
                            if ((!n.able()) && null == v) {
                                response = ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),
                                        String.format("%s%s", n.name(), n.value()));
                            }
                        }
                    }

                    //檢查數據版本
                    DataVersion d = field.getAnnotation(DataVersion.class);
                    if (null != d) {
                        if (ma.action() == ActionType.UPDATE || ma.action() == ActionType.DELETE) {
                            v = field.get(obj);
                            if (null == v) {
                                response = ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),
                                        String.format("%s%s", "數據版本", "不能為空"));
                            }
                        }
                        if (ma.action() == ActionType.INSERT) {
                            field.set(obj, 0);
                        }
                    }

                }
            }
        }
        if (!response.isSuccess()) {
            return response;
        }

        //執行後續方法
        try {
            ret = joinPoint.proceed(args);
        } catch (Throwable throwable) {
            log.info("====================執行目標方法異常============", throwable);
            return ServerResponse.createByErrorMessage(throwable.getMessage());
        }
        return ret;
    }
}
