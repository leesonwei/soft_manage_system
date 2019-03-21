package com.service.impl;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.service.TweiUserService;
import com.dao.TweiUserDao;
import com.common.Assist;
import com.dto.TweiUser;
/**
 * TweiUser的服务接口的实现类
 * 
 * @author 
 *
 */
@Service
public class TweiUserServiceImpl implements TweiUserService {
	private final Logger LOG = LogManager.getLogger(this.getClass());

	@Autowired
	private TweiUserDao tweiUserDao;
	// TODO 当你看到这个方法时你应该创建一个工具类做通用的方法,定义自己的返回格式化
	private static final int C200 = 200;
	private static final int C412 = 412;
	public String resultFormat(int code, Object data) {
		JSONObject result = new JSONObject();
		result.put("code", code);
		if (data != null) {
			result.put("data", data);
		}
		return result.toJSONString();
	}

	@Override
	public String find(TweiUser value) {
		//TODO这里可以做通过Assist做添加查询
		List<TweiUser> result = tweiUserDao.selectTweiUser(null);
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行获取TweiUser数据集-->结果:", result);
		}
		return resultFormat(C200, result);
	}
	@Override
	public String findOne(String id) {
		if (id == null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("执行通过TweiUser的id获得TweiUser对象-->失败:id不能为空");
			}
			return resultFormat(C412, null);
		}
		TweiUser result = tweiUserDao.selectTweiUserById(id);
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行通过TweiUser的id获得TweiUser对象-->结果:", result);
		}
		return resultFormat(C200, result);
	}

	@Override
	public String saveNotNull(TweiUser value) {
		if (value == null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("执行将TweiUser中属性值不为null的数据保存到数据库-->失败:对象不能为空");
			}
			return resultFormat(C412, null);
		}
		int result = tweiUserDao.insertNotNullTweiUser(value);
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行将TweiUser中属性值不为null的数据保存到数据库-->结果:", result);
		}
		return resultFormat(C200, result);
	}
	@Override
	public String updateNotNullById(TweiUser value) {
		if (value == null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("执行通过TweiUser的id更新TweiUser中属性不为null的数据-->失败:对象为null");
			}
			return resultFormat(C412, null);
		}
		int result = tweiUserDao.updateNotNullTweiUserById(value);
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行通过TweiUser的id更新TweiUser中属性不为null的数据-->结果:", result);
		}
		return resultFormat(C200, result);
	}

	@Override
	public String deleteById(String id) {
		if (id == null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("执行通过TweiUser的id删除TweiUser-->失败:id不能为空");
			}
			return resultFormat(C412, null);
		}
		int result = tweiUserDao.deleteTweiUserById(id);
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行通过TweiUser的id删除TweiUser-->结果:", result);
		}
		return resultFormat(C200, result);
	}


}