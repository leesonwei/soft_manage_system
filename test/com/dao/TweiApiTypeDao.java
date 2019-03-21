package com.dao;
import java.util.List;

import com.common.Assist;
import com.dto.TweiApiType;

import org.apache.ibatis.annotations.Param;
/**
 * TweiApiType的Dao接口
 * 
 * @author 
 *
 */
public interface TweiApiTypeDao {

	/**
	 * 获得TweiApiType数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * 
	 * @param assist
	 * @return
	 */
	long getTweiApiTypeRowCount(Assist assist);
	
	/**
	 * 获得TweiApiType数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * 
	 * @param assist
	 * @return
	 */
	List<TweiApiType> selectTweiApiType(Assist assist);
	
	/**
	 * 获得一个TweiApiType对象,以参数TweiApiType对象中不为空的属性作为条件进行查询,返回符合条件的第一条
	 * 
	 * @param obj
	 * @return
	 */
	TweiApiType selectTweiApiTypeObjSingle(TweiApiType obj);
	
	/**
	 * 获得一个TweiApiType对象,以参数TweiApiType对象中不为空的属性作为条件进行查询
	 * 
	 * @param obj
	 * @return
	 */
	List<TweiApiType> selectTweiApiTypeByObj(TweiApiType obj);

	/**
	 * 插入TweiApiType到数据库,包括null值
	 * 
	 * @param value
	 * @return
	 */
	int insertTweiApiType(TweiApiType value);
	
	/**
	 * 插入TweiApiType中属性值不为null的数据到数据库
	 * 
	 * @param value
	 * @return
	 */
	int insertNotNullTweiApiType(TweiApiType value);
	
	/**
	 * 批量插入TweiApiType到数据库,包括null值
	 * 
	 * @param value
	 * @return
	 */
	int insertTweiApiTypeByBatch(List<TweiApiType> value);
	
	/**
	 * 通过辅助工具Assist的条件删除TweiApiType
	 * 
	 * @param assist
	 * @return
	 */
	int deleteTweiApiTypeByAssist(Assist assist);
	
	
	/**
	 * 通过辅助工具Assist的条件更新TweiApiType中的数据,包括null值
	 * 
	 * @param value
	 * @param assist
	 * @return
	 */
	int updateTweiApiType(@Param("enti") TweiApiType value, @Param("assist") Assist assist);
	
	/**
	 * 通过辅助工具Assist的条件更新TweiApiType中属性不为null的数据
	 * 
	 * @param value
	 * @param assist
	 * @return
	 */
	int updateNotNullTweiApiType(@Param("enti") TweiApiType value, @Param("assist") Assist assist);
}