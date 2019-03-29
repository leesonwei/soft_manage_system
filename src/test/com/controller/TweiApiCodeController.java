package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.TweiApiCodeService;
import com.entity.TweiApiCode;

/**
 * TweiApiCode的路由接口服务
 * 
 * @author 
 *
 */
@RestController
public class TweiApiCodeController {

	/** TweiApiCodeService服务 */
	@Autowired
	private TweiApiCodeService tweiApiCodeService;
	
	/**
	 * 查询所有TweiApiCode数据的方法
	 * @param value
	 * @return
	 */
	@GetMapping(value = "/TweiApiCode", produces = {"application/json;charset=UTF-8"})
	public String find(TweiApiCode value) {
		return tweiApiCodeService.find(value);
	}
	
	
	/**
	 * 插入TweiApiCode属性不为空的数据方法
	 * @param id
	 * @return
	 */
	@PostMapping(value = "/TweiApiCode", produces = {"application/json;charset=UTF-8"})
	public String save(TweiApiCode value) {
		return tweiApiCodeService.saveNotNull(value);
	}
	
}
