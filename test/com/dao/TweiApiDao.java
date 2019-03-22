package com.dao;
import java.util.List;

import com.common.Assist;
import com.dto.TweiApi;

import org.apache.ibatis.annotations.Param;
/**
 * TweiApi的Dao接口
 * 
 * @author 
 *
 */
public interface TweiApiDao {

	/**
	 * 获得TweiApi数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * 
	 * @param assist
	 * @return
	 */
	long getTweiApiRowCount(Assist assist);
	
	/**
	 * 获得TweiApi数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * 
	 * @param assist
	 * @return
	 */
	List<TweiApi> selectTweiApi(Assist assist);
	
	/**
	 * 获得一个TweiApi对象,以参数TweiApi对象中不为空的属性作为条件进行查询,返回符合条件的第一条
	 * 
	 * @param obj
	 * @return
	 */
	TweiApi selectTweiApiObjSingle(TweiApi obj);
	
	/**
	 * 获得一个TweiApi对象,以参数TweiApi对象中不为空的属性作为条件进行查询
	 * 
	 * @param obj
	 * @return
	 */
	List<TweiApi> selectTweiApiByObj(TweiApi obj);

	/**
	 * 插入TweiApi到数据库,包括null值
	 * 
	 * @param value
	 * @return
	 */
	int insertTweiApi(TweiApi value);
	
	/**
	 * 插入TweiApi中属性值不为null的数据到数据库
	 * 
	 * @param value
	 * @return
	 */
	int insertNotNullTweiApi(TweiApi value);
	
	/**
	 * 批量插入TweiApi到数据库,包括null值
	 * 
	 * @param value
	 * @return
	 */
	int insertTweiApiByBatch(List<TweiApi> value);
	
	/**
	 * 通过辅助工具Assist的条件删除TweiApi
	 * 
	 * @param assist
	 * @return
	 */
	int deleteTweiApiByAssist(Assist assist);
	
	
	/**
	 * 通过辅助工具Assist的条件更新TweiApi中的数据,包括null值
	 * 
	 * @param value
	 * @param assist
	 * @return
	 */
	int updateTweiApi(@Param("enti") TweiApi value, @Param("assist") Assist assist);
	
	/**
	 * 通过辅助工具Assist的条件更新TweiApi中属性不为null的数据
	 * 
	 * @param value
	 * @param assist
	 * @return
	 */
	int updateNotNullTweiApi(@Param("enti") TweiApi value, @Param("assist") Assist assist);
}