package com.dao;
import java.util.List;

import com.common.Assist;
import com.dto.TweiUser;

import org.apache.ibatis.annotations.Param;
/**
 * TweiUser的Dao接口
 * 
 * @author 
 *
 */
public interface TweiUserDao {

	/**
	 * 获得TweiUser数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * 
	 * @param assist
	 * @return
	 */
	long getTweiUserRowCount(Assist assist);
	
	/**
	 * 获得TweiUser数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * 
	 * @param assist
	 * @return
	 */
	List<TweiUser> selectTweiUser(Assist assist);
	/**
	 * 通过TweiUser的id获得TweiUser对象
	 * 
	 * @param id
	 * @return
	 */
	TweiUser selectTweiUserById(String id);
	
	/**
	 * 获得一个TweiUser对象,以参数TweiUser对象中不为空的属性作为条件进行查询,返回符合条件的第一条
	 * 
	 * @param obj
	 * @return
	 */
	TweiUser selectTweiUserObjSingle(TweiUser obj);
	
	/**
	 * 获得一个TweiUser对象,以参数TweiUser对象中不为空的属性作为条件进行查询
	 * 
	 * @param obj
	 * @return
	 */
	List<TweiUser> selectTweiUserByObj(TweiUser obj);

	/**
	 * 插入TweiUser到数据库,包括null值
	 * 
	 * @param value
	 * @return
	 */
	int insertTweiUser(TweiUser value);
	
	/**
	 * 插入TweiUser中属性值不为null的数据到数据库
	 * 
	 * @param value
	 * @return
	 */
	int insertNotNullTweiUser(TweiUser value);
	
	/**
	 * 批量插入TweiUser到数据库,包括null值
	 * 
	 * @param value
	 * @return
	 */
	int insertTweiUserByBatch(List<TweiUser> value);
	/**
	 * 通过TweiUser的id删除TweiUser
	 * 
	 * @param id
	 * @return
	 */
	int deleteTweiUserById(String id);
	
	/**
	 * 通过辅助工具Assist的条件删除TweiUser
	 * 
	 * @param assist
	 * @return
	 */
	int deleteTweiUserByAssist(Assist assist);
	
	/**
	 * 通过TweiUser的id更新TweiUser中的数据,包括null值
	 * 
	 * @param enti
	 * @return
	 */
	int updateTweiUserById(TweiUser enti);
	
	/**
	 * 通过TweiUser的id更新TweiUser中属性不为null的数据
	 * 
	 * @param enti
	 * @return
	 */
	int updateNotNullTweiUserById(TweiUser enti);
	
	/**
	 * 通过辅助工具Assist的条件更新TweiUser中的数据,包括null值
	 * 
	 * @param value
	 * @param assist
	 * @return
	 */
	int updateTweiUser(@Param("enti") TweiUser value, @Param("assist") Assist assist);
	
	/**
	 * 通过辅助工具Assist的条件更新TweiUser中属性不为null的数据
	 * 
	 * @param value
	 * @param assist
	 * @return
	 */
	int updateNotNullTweiUser(@Param("enti") TweiUser value, @Param("assist") Assist assist);
}