package com.delta.soft_manage_system.log2db;

import com.delta.auth.dto.TweiUser;
import com.delta.common.constant.GlobalConst;
import com.delta.common.utils.ServerResponse;
import com.delta.soft_manage_system.dao.AutoIdDao;
import com.delta.soft_manage_system.dao.LogMapper;
import com.delta.soft_manage_system.dto.AutoId;
import com.delta.soft_manage_system.dto.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Calendar;

/**
 * @Classname Log2dbAspect
 * @Date 2019/4/8 18:55
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@Aspect
@Component
public class Log2dbAspect {
    private Logger logger = LoggerFactory.getLogger(Log2dbAspect.class);
    @Autowired
    private LogMapper logMapper;

    @Autowired
    private AutoIdDao autoIdDao;

    @Autowired
    private HttpSession httpSession;

    @Pointcut("@annotation(com.delta.soft_manage_system.log2db.Log2db)")
    public void log2db(){}

    @Around("log2db()")
    public Object doLog2db(ProceedingJoinPoint joinPoint) {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder();
        Object[] args = joinPoint.getArgs();
        Class<?>[] argTypes = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            argTypes[i] = args[i].getClass();
            stringBuilder.append(args[i].toString());
        }
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Log2db l = method.getAnnotation(Log2db.class);
        Log log = new Log();
        log.setLogType(l.value());
        log.setLogAt(Calendar.getInstance().getTime());
        log.setLogContent(stringBuilder.toString());
        TweiUser user = (TweiUser) httpSession.getAttribute(GlobalConst.CURRENT_USER);
        if (user != null) {
            log.setLogBy(user.getUserid());
        }
        try {
            obj = joinPoint.proceed(args);
            if (user == null) {
                user = (TweiUser) httpSession.getAttribute(GlobalConst.CURRENT_USER);
                if (null != user){
                    log.setLogBy(user.getUserid());
                }
            }
            log.setLogResult(obj.toString());
            this.log(log);
        } catch (Throwable throwable) {
            logger.info("====================執行目標方法異常============", throwable);
            log.setLogResult(throwable.getMessage());
            this.log(log);
            return ServerResponse.createByErrorMessage("服務器異常");
        }
        return obj;
    }

    private void log(Log log){
        AutoId autoId = new AutoId();
        autoId.setTableName("twei_app_log");
        autoId.setPrefix(null);
        autoIdDao.getAutoId(autoId);
        log.setLogId(autoId.getAutoid());
        int count = logMapper.insert(log);
        if (count != 1) {
            logger.info("記錄系統日誌異常" + log.toString());
        }
    }
}
