package com.dao;
import java.util.List;

import com.common.Assist;
import com.dto.TweiApiCode;

import org.apache.ibatis.annotations.Param;
/**
 * TweiApiCode的Dao接口
 * 
 * @author 
 *
 */
public interface TweiApiCodeDao {

	/**
	 * 获得TweiApiCode数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * 
	 * @param assist
	 * @return
	 */
	long getTweiApiCodeRowCount(Assist assist);
	
	/**
	 * 获得TweiApiCode数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * 
	 * @param assist
	 * @return
	 */
	List<TweiApiCode> selectTweiApiCode(Assist assist);
	
	/**
	 * 获得一个TweiApiCode对象,以参数TweiApiCode对象中不为空的属性作为条件进行查询,返回符合条件的第一条
	 * 
	 * @param obj
	 * @return
	 */
	TweiApiCode selectTweiApiCodeObjSingle(TweiApiCode obj);
	
	/**
	 * 获得一个TweiApiCode对象,以参数TweiApiCode对象中不为空的属性作为条件进行查询
	 * 
	 * @param obj
	 * @return
	 */
	List<TweiApiCode> selectTweiApiCodeByObj(TweiApiCode obj);

	/**
	 * 插入TweiApiCode到数据库,包括null值
	 * 
	 * @param value
	 * @return
	 */
	int insertTweiApiCode(TweiApiCode value);
	
	/**
	 * 插入TweiApiCode中属性值不为null的数据到数据库
	 * 
	 * @param value
	 * @return
	 */
	int insertNotNullTweiApiCode(TweiApiCode value);
	
	/**
	 * 批量插入TweiApiCode到数据库,包括null值
	 * 
	 * @param value
	 * @return
	 */
	int insertTweiApiCodeByBatch(List<TweiApiCode> value);
	
	/**
	 * 通过辅助工具Assist的条件删除TweiApiCode
	 * 
	 * @param assist
	 * @return
	 */
	int deleteTweiApiCodeByAssist(Assist assist);
	
	
	/**
	 * 通过辅助工具Assist的条件更新TweiApiCode中的数据,包括null值
	 * 
	 * @param value
	 * @param assist
	 * @return
	 */
	int updateTweiApiCode(@Param("enti") TweiApiCode value, @Param("assist") Assist assist);
	
	/**
	 * 通过辅助工具Assist的条件更新TweiApiCode中属性不为null的数据
	 * 
	 * @param value
	 * @param assist
	 * @return
	 */
	int updateNotNullTweiApiCode(@Param("enti") TweiApiCode value, @Param("assist") Assist assist);
}