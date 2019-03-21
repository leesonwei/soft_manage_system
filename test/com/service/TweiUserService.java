package com.service;
import java.util.List;

import com.service.impl.TweiUserServiceImpl;
import com.common.Assist;
import com.dto.TweiUser;

/**
 * TweiUser的服务接口
 * 
 * @author 
 *
 */
public interface TweiUserService {
	/**
	 * 获得TweiUser数据集,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * 
	 * @return
	 */
	String find(TweiUser value);
	
	/**
	 * 通过TweiUser的id获得TweiUser对象
	 * 
	 * @param id
	 * @return
	 */
	String findOne(String id);
	
	/**
	 * 将TweiUser中属性值不为null的数据到数据库
	 * 
	 * @param value
	 * @return
	 */
	String saveNotNull(TweiUser value);
	
	/**
	 * 通过TweiUser的id更新TweiUser中属性不为null的数据
	 * 
	 * @param enti
	 * @return
	 */
	String updateNotNullById(TweiUser enti);
	
	/**
	 * 通过TweiUser的id删除TweiUser
	 * 
	 * @param id
	 * @return
	 */
	String deleteById(String id);
}
