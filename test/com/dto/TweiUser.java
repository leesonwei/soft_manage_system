package com.dto;

import com.alibaba.fastjson.JSONObject;

/**
 * twei_user实体类
 * 
 * @author 
 *
 */
public class TweiUser {
	/***/
	private String userid; 
	/***/
	private String userName; 
	/***/
	private String password; 
	/**
	 * 实例化
	 */
	public TweiUser() {
		super();
	}
	/**
	 * 实例化
	 * 
	 * @param obj
	 */
	public TweiUser(JSONObject obj) {
		this();
		if (obj.get("userid") instanceof String) {
			this.setUserid((String) obj.get("userid"));
		}
		if (obj.get("userName") instanceof String) {
			this.setUserName((String) obj.get("userName"));
		}
		if (obj.get("password") instanceof String) {
			this.setPassword((String) obj.get("password"));
		}
	}
	
	/**
	 * 将当前对象转换为JsonObject
	 * 
	 * @return
	 */
	public JSONObject toJson() {
		JSONObject result = new JSONObject();
		if (this.getUserid() != null) {
			result.put("userid",this.getUserid());
		}
		if (this.getUserName() != null) {
			result.put("userName",this.getUserName());
		}
		if (this.getPassword() != null) {
			result.put("password",this.getPassword());
		}
		return result;
	}
	
	
	/**
	 * 获取userid
	 * 
	 * @return
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 设置userid
	 * 
	 * @param userid
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	/**
	 * 获取userName
	 * 
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置userName
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * 获取password
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置password
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "TweiUser [userid=" + userid + " , userName=" + userName + " , password=" + password + "  ]";
	
	}
	
	
}
