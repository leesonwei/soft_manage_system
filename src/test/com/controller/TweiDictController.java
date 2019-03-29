package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.TweiDictService;
import com.entity.TweiDict;

/**
 * TweiDict的路由接口服务
 * 
 * @author 
 *
 */
@RestController
public class TweiDictController {

	/** TweiDictService服务 */
	@Autowired
	private TweiDictService tweiDictService;
	
	/**
	 * 查询所有TweiDict数据的方法
	 * @param value
	 * @return
	 */
	@GetMapping(value = "/TweiDict", produces = {"application/json;charset=UTF-8"})
	public String find(TweiDict value) {
		return tweiDictService.find(value);
	}
	
	
	/**
	 * 插入TweiDict属性不为空的数据方法
	 * @param id
	 * @return
	 */
	@PostMapping(value = "/TweiDict", produces = {"application/json;charset=UTF-8"})
	public String save(TweiDict value) {
		return tweiDictService.saveNotNull(value);
	}
	
}
