package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.TweiDictTypeService;
import com.dto.TweiDictType;

/**
 * TweiDictType的路由接口服务
 * 
 * @author 
 *
 */
@RestController
public class TweiDictTypeController {

	/** TweiDictTypeService服务 */
	@Autowired
	private TweiDictTypeService tweiDictTypeService;
	
	/**
	 * 查询所有TweiDictType数据的方法
	 * @param value
	 * @return
	 */
	@GetMapping(value = "/TweiDictType", produces = {"application/json;charset=UTF-8"})
	public String find(TweiDictType value) {
		return tweiDictTypeService.find(value);
	}
	
	
	/**
	 * 插入TweiDictType属性不为空的数据方法
	 * @param id
	 * @return
	 */
	@PostMapping(value = "/TweiDictType", produces = {"application/json;charset=UTF-8"})
	public String save(TweiDictType value) {
		return tweiDictTypeService.saveNotNull(value);
	}
	
}
