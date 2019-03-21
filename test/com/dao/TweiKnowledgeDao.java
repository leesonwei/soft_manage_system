package com.dao;
import java.util.List;

import com.common.Assist;
import com.dto.TweiKnowledge;

import org.apache.ibatis.annotations.Param;
/**
 * TweiKnowledge的Dao接口
 * 
 * @author 
 *
 */
public interface TweiKnowledgeDao {

	/**
	 * 获得TweiKnowledge数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * 
	 * @param assist
	 * @return
	 */
	long getTweiKnowledgeRowCount(Assist assist);
	
	/**
	 * 获得TweiKnowledge数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * 
	 * @param assist
	 * @return
	 */
	List<TweiKnowledge> selectTweiKnowledge(Assist assist);
	
	/**
	 * 获得一个TweiKnowledge对象,以参数TweiKnowledge对象中不为空的属性作为条件进行查询,返回符合条件的第一条
	 * 
	 * @param obj
	 * @return
	 */
	TweiKnowledge selectTweiKnowledgeObjSingle(TweiKnowledge obj);
	
	/**
	 * 获得一个TweiKnowledge对象,以参数TweiKnowledge对象中不为空的属性作为条件进行查询
	 * 
	 * @param obj
	 * @return
	 */
	List<TweiKnowledge> selectTweiKnowledgeByObj(TweiKnowledge obj);

	/**
	 * 插入TweiKnowledge到数据库,包括null值
	 * 
	 * @param value
	 * @return
	 */
	int insertTweiKnowledge(TweiKnowledge value);
	
	/**
	 * 插入TweiKnowledge中属性值不为null的数据到数据库
	 * 
	 * @param value
	 * @return
	 */
	int insertNotNullTweiKnowledge(TweiKnowledge value);
	
	/**
	 * 批量插入TweiKnowledge到数据库,包括null值
	 * 
	 * @param value
	 * @return
	 */
	int insertTweiKnowledgeByBatch(List<TweiKnowledge> value);
	
	/**
	 * 通过辅助工具Assist的条件删除TweiKnowledge
	 * 
	 * @param assist
	 * @return
	 */
	int deleteTweiKnowledgeByAssist(Assist assist);
	
	
	/**
	 * 通过辅助工具Assist的条件更新TweiKnowledge中的数据,包括null值
	 * 
	 * @param value
	 * @param assist
	 * @return
	 */
	int updateTweiKnowledge(@Param("enti") TweiKnowledge value, @Param("assist") Assist assist);
	
	/**
	 * 通过辅助工具Assist的条件更新TweiKnowledge中属性不为null的数据
	 * 
	 * @param value
	 * @param assist
	 * @return
	 */
	int updateNotNullTweiKnowledge(@Param("enti") TweiKnowledge value, @Param("assist") Assist assist);
}