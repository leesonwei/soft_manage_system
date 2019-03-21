package com.dao;
import java.util.List;

import com.common.Assist;
import com.dto.TweiDictType;

import org.apache.ibatis.annotations.Param;
/**
 * TweiDictType的Dao接口
 * 
 * @author 
 *
 */
public interface TweiDictTypeDao {

	/**
	 * 获得TweiDictType数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * 
	 * @param assist
	 * @return
	 */
	long getTweiDictTypeRowCount(Assist assist);
	
	/**
	 * 获得TweiDictType数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * 
	 * @param assist
	 * @return
	 */
	List<TweiDictType> selectTweiDictType(Assist assist);
	
	/**
	 * 获得一个TweiDictType对象,以参数TweiDictType对象中不为空的属性作为条件进行查询,返回符合条件的第一条
	 * 
	 * @param obj
	 * @return
	 */
	TweiDictType selectTweiDictTypeObjSingle(TweiDictType obj);
	
	/**
	 * 获得一个TweiDictType对象,以参数TweiDictType对象中不为空的属性作为条件进行查询
	 * 
	 * @param obj
	 * @return
	 */
	List<TweiDictType> selectTweiDictTypeByObj(TweiDictType obj);

	/**
	 * 插入TweiDictType到数据库,包括null值
	 * 
	 * @param value
	 * @return
	 */
	int insertTweiDictType(TweiDictType value);
	
	/**
	 * 插入TweiDictType中属性值不为null的数据到数据库
	 * 
	 * @param value
	 * @return
	 */
	int insertNotNullTweiDictType(TweiDictType value);
	
	/**
	 * 批量插入TweiDictType到数据库,包括null值
	 * 
	 * @param value
	 * @return
	 */
	int insertTweiDictTypeByBatch(List<TweiDictType> value);
	
	/**
	 * 通过辅助工具Assist的条件删除TweiDictType
	 * 
	 * @param assist
	 * @return
	 */
	int deleteTweiDictTypeByAssist(Assist assist);
	
	
	/**
	 * 通过辅助工具Assist的条件更新TweiDictType中的数据,包括null值
	 * 
	 * @param value
	 * @param assist
	 * @return
	 */
	int updateTweiDictType(@Param("enti") TweiDictType value, @Param("assist") Assist assist);
	
	/**
	 * 通过辅助工具Assist的条件更新TweiDictType中属性不为null的数据
	 * 
	 * @param value
	 * @param assist
	 * @return
	 */
	int updateNotNullTweiDictType(@Param("enti") TweiDictType value, @Param("assist") Assist assist);
}