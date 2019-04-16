package com.delta.soft_manage_system.config;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.delta.common.constant.GlobalConst;
import com.delta.common.utils.DateUtil;
import com.delta.soft_manage_system.dao.LogMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/**
 * @Classname LogDeleteConfig
 * @Date 2019/4/9 10:47
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@Configuration
@EnableAsync
@EnableScheduling
@Slf4j
public class LogDeleteConfig {
    @Autowired
    private LogMapper logMapper;

    @Async
    @Scheduled(cron="0 0 12 1/1 * ?")
    public void deleteLog(){
        log.info(String.format("執行日誌刪除任務:%s", DateUtil.getCurrentTime(GlobalConst.DATE_TIME_FORMAT)));
        int count = logMapper.delete(getWrapper());
        log.info(String.format("共刪除日誌%d條" , count));
    }

    private EntityWrapper getWrapper(){
        EntityWrapper wrapper = new EntityWrapper();
        wrapper.le("log_at", DateUtil.addDay(new Date(System.currentTimeMillis()),-1));
        return wrapper;
    }
}
