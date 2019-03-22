package com.delta.soft_manage_system.common;

/**
 * 全局配置常量
 * @author lizong.wei
 *
 */
public class JWTConstant {
	/**
	 * 成功
	 */
	public static final int RESCODE_SUCCESS = 1000;
	
	/**
	 * 失败
	 */
	//请求抛出异常
	public static final int RESCODE_EXCEPTION = 1001;
	//未登陆状态
	public static final int RESCODE_NOLOGIN = 1002;
	//无操作权限
	public static final int RESCODE_NOAUTH = 1003;
	//登录过期
	public static final int RESCODE_LOGINEXPIRE = 1004;
	
	/**
	 * token
	 */
	//Token过期
	public static final int JWT_ERRCODE_EXPIRE = 1005;
	//验证不通过
	public static final int JWT_ERRCODE_FAIL = 1006;

	/**
	 * jwt
	 */
	//jwt签发者
	public static final String JWT_ISS = "jwt-delta";
	//密匙
	public static final String JWT_SECERT = "46cc793c53dc451b8a4fe2cd0bb00847";
	//token有效时间,单位毫秒
	public static final long JWT_TTL = 2 *60*60*1000;
	
}