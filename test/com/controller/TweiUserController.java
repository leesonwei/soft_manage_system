package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.TweiUserService;
import com.dto.TweiUser;

/**
 * TweiUser的路由接口服务
 * 
 * @author 
 *
 */
@RestController
public class TweiUserController {

	/** TweiUserService服务 */
	@Autowired
	private TweiUserService tweiUserService;
	
	/**
	 * 查询所有TweiUser数据的方法
	 * @param value
	 * @return
	 */
	@GetMapping(value = "/TweiUser", produces = {"application/json;charset=UTF-8"})
	public String find(TweiUser value) {
		return tweiUserService.find(value);
	}
	
	/**
	 * 通过id查询TweiUser数据的方法
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/TweiUser/{id}", produces = {"application/json;charset=UTF-8"})
	public String findOne(@PathVariable(name="id") String id) {
		return tweiUserService.findOne(id);
	}
	
	/**
	 * 插入TweiUser属性不为空的数据方法
	 * @param id
	 * @return
	 */
	@PostMapping(value = "/TweiUser", produces = {"application/json;charset=UTF-8"})
	public String save(TweiUser value) {
		return tweiUserService.saveNotNull(value);
	}
	
	/**
	 * 更新TweiUser属性不为空的数据方法
	 * @param id
	 * @return
	 */
	@PutMapping(value = "/TweiUser", produces = {"application/json;charset=UTF-8"})
	public String update(TweiUser value) {
		return tweiUserService.updateNotNullById(value);
	}

	/**
	 * 通过id删除TweiUser数据方法
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/TweiUser/{id}", produces = {"application/json;charset=UTF-8"})
	public String delete(@PathVariable(name="id") String id) {
		return tweiUserService.deleteById(id);
	}
}
