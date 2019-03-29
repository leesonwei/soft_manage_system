package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * TweiApiPara的测试
 * 
 * @author 
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TweiApiParaTest {
	@Autowired
	private MockMvc mvc;

	/**
	 * 单元测试:查询所有TweiApiPara数据的方法
	 * @throws Exception
	 */
	@Test
	public void findTest() throws Exception {
		ResultActions action = mvc.perform(MockMvcRequestBuilders.get("/TweiApiPara")).andExpect(MockMvcResultMatchers.status().isOk());
		// TODO 当你看到这个后你应该自己修改模板编写测试内容规则
	}
	
	
	/**
	 * 单元测试:插入TweiApiPara属性不为空的数据方法
	 * @throws Exception
	 */
	@Test
	public void saveTest() throws Exception {
		ResultActions action = mvc.perform(MockMvcRequestBuilders.post("/TweiApiPara")).andExpect(MockMvcResultMatchers.status().isOk());
		// TODO 当你看到这个后你应该自己修改模板编写测试内容规则
	}
	
	/**
	 * 单元测试:更新TweiApiPara属性不为空的数据方法
	 * @throws Exception
	 */
	@Test
	public void updateTest() throws Exception {
		ResultActions action = mvc.perform(MockMvcRequestBuilders.put("/TweiApiPara")).andExpect(MockMvcResultMatchers.status().isOk());
		// TODO 当你看到这个后你应该自己修改模板编写测试内容规则
	}

}