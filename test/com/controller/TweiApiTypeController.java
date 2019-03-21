package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.TweiApiTypeService;
import com.dto.TweiApiType;

/**
 * TweiApiType的路由接口服务
 * 
 * @author 
 *
 */
@RestController
public class TweiApiTypeController {

	/** TweiApiTypeService服务 */
	@Autowired
	private TweiApiTypeService tweiApiTypeService;
	
	/**
	 * 查询所有TweiApiType数据的方法
	 * @param value
	 * @return
	 */
	@GetMapping(value = "/TweiApiType", produces = {"application/json;charset=UTF-8"})
	public String find(TweiApiType value) {
		return tweiApiTypeService.find(value);
	}
	
	
	/**
	 * 插入TweiApiType属性不为空的数据方法
	 * @param id
	 * @return
	 */
	@PostMapping(value = "/TweiApiType", produces = {"application/json;charset=UTF-8"})
	public String save(TweiApiType value) {
		return tweiApiTypeService.saveNotNull(value);
	}
	
}
