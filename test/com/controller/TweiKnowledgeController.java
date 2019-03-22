package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.TweiKnowledgeService;
import com.dto.TweiKnowledge;

/**
 * TweiKnowledge的路由接口服务
 * 
 * @author 
 *
 */
@RestController
public class TweiKnowledgeController {

	/** TweiKnowledgeService服务 */
	@Autowired
	private TweiKnowledgeService tweiKnowledgeService;
	
	/**
	 * 查询所有TweiKnowledge数据的方法
	 * @param value
	 * @return
	 */
	@GetMapping(value = "/TweiKnowledge", produces = {"application/json;charset=UTF-8"})
	public String find(TweiKnowledge value) {
		return tweiKnowledgeService.find(value);
	}
	
	
	/**
	 * 插入TweiKnowledge属性不为空的数据方法
	 * @param id
	 * @return
	 */
	@PostMapping(value = "/TweiKnowledge", produces = {"application/json;charset=UTF-8"})
	public String save(TweiKnowledge value) {
		return tweiKnowledgeService.saveNotNull(value);
	}
	
}
