package com.dao;
import java.util.List;

import com.common.Assist;
import com.dto.TweiApiPara;

import org.apache.ibatis.annotations.Param;
/**
 * TweiApiPara的Dao接口
 * 
 * @author 
 *
 */
public interface TweiApiParaDao {

	/**
	 * 获得TweiApiPara数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * 
	 * @param assist
	 * @return
	 */
	long getTweiApiParaRowCount(Assist assist);
	
	/**
	 * 获得TweiApiPara数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * 
	 * @param assist
	 * @return
	 */
	List<TweiApiPara> selectTweiApiPara(Assist assist);
	
	/**
	 * 获得一个TweiApiPara对象,以参数TweiApiPara对象中不为空的属性作为条件进行查询,返回符合条件的第一条
	 * 
	 * @param obj
	 * @return
	 */
	TweiApiPara selectTweiApiParaObjSingle(TweiApiPara obj);
	
	/**
	 * 获得一个TweiApiPara对象,以参数TweiApiPara对象中不为空的属性作为条件进行查询
	 * 
	 * @param obj
	 * @return
	 */
	List<TweiApiPara> selectTweiApiParaByObj(TweiApiPara obj);

	/**
	 * 插入TweiApiPara到数据库,包括null值
	 * 
	 * @param value
	 * @return
	 */
	int insertTweiApiPara(TweiApiPara value);
	
	/**
	 * 插入TweiApiPara中属性值不为null的数据到数据库
	 * 
	 * @param value
	 * @return
	 */
	int insertNotNullTweiApiPara(TweiApiPara value);
	
	/**
	 * 批量插入TweiApiPara到数据库,包括null值
	 * 
	 * @param value
	 * @return
	 */
	int insertTweiApiParaByBatch(List<TweiApiPara> value);
	
	/**
	 * 通过辅助工具Assist的条件删除TweiApiPara
	 * 
	 * @param assist
	 * @return
	 */
	int deleteTweiApiParaByAssist(Assist assist);
	
	
	/**
	 * 通过辅助工具Assist的条件更新TweiApiPara中的数据,包括null值
	 * 
	 * @param value
	 * @param assist
	 * @return
	 */
	int updateTweiApiPara(@Param("enti") TweiApiPara value, @Param("assist") Assist assist);
	
	/**
	 * 通过辅助工具Assist的条件更新TweiApiPara中属性不为null的数据
	 * 
	 * @param value
	 * @param assist
	 * @return
	 */
	int updateNotNullTweiApiPara(@Param("enti") TweiApiPara value, @Param("assist") Assist assist);
}