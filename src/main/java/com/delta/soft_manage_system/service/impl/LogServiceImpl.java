package com.delta.soft_manage_system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.delta.soft_manage_system.dao.LogMapper;
import com.delta.soft_manage_system.dto.Log;
import com.delta.soft_manage_system.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname LogServiceImpl
 * @Date 2019/4/9 09:36
 * @Author LIZONG.WEI
 * @Since 1.8
 */
@Service
public class LogServiceImpl extends BaseServiceImpl<LogMapper, Log> implements LogService {

    @Autowired
    public LogServiceImpl(LogMapper logMapper) {
        super(logMapper);
    }

    @Override
    protected EntityWrapper<Log> getDeleteAndUpdateWrapper(Log log) {
        EntityWrapper<Log> wrapper = new EntityWrapper<>();
        wrapper.eq("log_ID",log.getLogId());
        return wrapper;
    }

    @Override
    protected Log updateDataVersion(Log log) {
        return null;
    }
}
