package com.service.impl;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.service.TweiKnowledgeService;
import com.dao.TweiKnowledgeDao;
import com.common.Assist;
import com.entity.TweiKnowledge;
/**
 * TweiKnowledge的服务接口的实现类
 * 
 * @author 
 *
 */
@Service
public class TweiKnowledgeServiceImpl implements TweiKnowledgeService {
	private final Logger LOG = LogManager.getLogger(this.getClass());

	@Autowired
	private TweiKnowledgeDao tweiKnowledgeDao;
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
	public String find(TweiKnowledge value) {
		//TODO这里可以做通过Assist做添加查询
		List<TweiKnowledge> result = tweiKnowledgeDao.selectTweiKnowledge(null);
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行获取TweiKnowledge数据集-->结果:", result);
		}
		return resultFormat(C200, result);
	}

	@Override
	public String saveNotNull(TweiKnowledge value) {
		if (value == null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("执行将TweiKnowledge中属性值不为null的数据保存到数据库-->失败:对象不能为空");
			}
			return resultFormat(C412, null);
		}
		if(value.getKnowId() == null || value.getKnowDetail() == null  ){
			if (LOG.isDebugEnabled()) {
				LOG.debug("执行将TweiKnowledge中属性值不为null的数据保存到数据库-->失败:存在不能为空的空值");
			}
			return resultFormat(C412, null);
		}
		int result = tweiKnowledgeDao.insertNotNullTweiKnowledge(value);
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行将TweiKnowledge中属性值不为null的数据保存到数据库-->结果:", result);
		}
		return resultFormat(C200, result);
	}


}