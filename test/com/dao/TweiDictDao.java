package com.dao;
import java.util.List;

import com.common.Assist;
import com.dto.TweiDict;

import org.apache.ibatis.annotations.Param;
/**
 * TweiDict的Dao接口
 * 
 * @author 
 *
 */
public interface TweiDictDao {

	/**
	 * 获得TweiDict数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * 
	 * @param assist
	 * @return
	 */
	long getTweiDictRowCount(Assist assist);
	
	/**
	 * 获得TweiDict数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * 
	 * @param assist
	 * @return
	 */
	List<TweiDict> selectTweiDict(Assist assist);
	
	/**
	 * 获得一个TweiDict对象,以参数TweiDict对象中不为空的属性作为条件进行查询,返回符合条件的第一条
	 * 
	 * @param obj
	 * @return
	 */
	TweiDict selectTweiDictObjSingle(TweiDict obj);
	
	/**
	 * 获得一个TweiDict对象,以参数TweiDict对象中不为空的属性作为条件进行查询
	 * 
	 * @param obj
	 * @return
	 */
	List<TweiDict> selectTweiDictByObj(TweiDict obj);

	/**
	 * 插入TweiDict到数据库,包括null值
	 * 
	 * @param value
	 * @return
	 */
	int insertTweiDict(TweiDict value);
	
	/**
	 * 插入TweiDict中属性值不为null的数据到数据库
	 * 
	 * @param value
	 * @return
	 */
	int insertNotNullTweiDict(TweiDict value);
	
	/**
	 * 批量插入TweiDict到数据库,包括null值
	 * 
	 * @param value
	 * @return
	 */
	int insertTweiDictByBatch(List<TweiDict> value);
	
	/**
	 * 通过辅助工具Assist的条件删除TweiDict
	 * 
	 * @param assist
	 * @return
	 */
	int deleteTweiDictByAssist(Assist assist);
	
	
	/**
	 * 通过辅助工具Assist的条件更新TweiDict中的数据,包括null值
	 * 
	 * @param value
	 * @param assist
	 * @return
	 */
	int updateTweiDict(@Param("enti") TweiDict value, @Param("assist") Assist assist);
	
	/**
	 * 通过辅助工具Assist的条件更新TweiDict中属性不为null的数据
	 * 
	 * @param value
	 * @param assist
	 * @return
	 */
	int updateNotNullTweiDict(@Param("enti") TweiDict value, @Param("assist") Assist assist);
}