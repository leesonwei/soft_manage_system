package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.TweiApiService;
import com.entity.TweiApi;

/**
 * TweiApi的路由接口服务
 * 
 * @author 
 *
 */
@RestController
public class TweiApiController {

	/** TweiApiService服务 */
	@Autowired
	private TweiApiService tweiApiService;
	
	/**
	 * 查询所有TweiApi数据的方法
	 * @param value
	 * @return
	 */
	@GetMapping(value = "/TweiApi", produces = {"application/json;charset=UTF-8"})
	public String find(TweiApi value) {
		return tweiApiService.find(value);
	}
	
	
	/**
	 * 插入TweiApi属性不为空的数据方法
	 * @param id
	 * @return
	 */
	@PostMapping(value = "/TweiApi", produces = {"application/json;charset=UTF-8"})
	public String save(TweiApi value) {
		return tweiApiService.saveNotNull(value);
	}
	
}
