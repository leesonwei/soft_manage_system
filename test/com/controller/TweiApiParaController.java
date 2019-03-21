package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.TweiApiParaService;
import com.dto.TweiApiPara;

/**
 * TweiApiPara的路由接口服务
 * 
 * @author 
 *
 */
@RestController
public class TweiApiParaController {

	/** TweiApiParaService服务 */
	@Autowired
	private TweiApiParaService tweiApiParaService;
	
	/**
	 * 查询所有TweiApiPara数据的方法
	 * @param value
	 * @return
	 */
	@GetMapping(value = "/TweiApiPara", produces = {"application/json;charset=UTF-8"})
	public String find(TweiApiPara value) {
		return tweiApiParaService.find(value);
	}
	
	
	/**
	 * 插入TweiApiPara属性不为空的数据方法
	 * @param id
	 * @return
	 */
	@PostMapping(value = "/TweiApiPara", produces = {"application/json;charset=UTF-8"})
	public String save(TweiApiPara value) {
		return tweiApiParaService.saveNotNull(value);
	}
	
}
